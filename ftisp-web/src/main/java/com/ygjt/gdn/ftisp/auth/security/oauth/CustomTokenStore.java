package com.ygjt.gdn.ftisp.auth.security.oauth;

import com.ygjt.gdn.ftisp.model.AccessTokenWithBLOBs;
import com.ygjt.gdn.ftisp.model.Query.AccessTokenQuery;
import com.ygjt.gdn.ftisp.model.Query.RefreshTokenQuery;
import com.ygjt.gdn.ftisp.model.RefreshTokenWithBLOBs;
import com.ygjt.gdn.ftisp.persistence.AccessTokenDao;
import com.ygjt.gdn.ftisp.persistence.RefreshTokenDao;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Je on 2016/10/20.
 */
public class CustomTokenStore implements TokenStore {

    @Resource
    private AccessTokenDao accessTokenDao;

    @Resource
    private RefreshTokenDao refreshTokenDao;

    private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();


    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken oAuth2AccessToken) {
        return this.readAuthentication(oAuth2AccessToken.getValue());
    }

    @Override
    public OAuth2Authentication readAuthentication(String token) {
        OAuth2Authentication authentication = null;
        String key = this.extractTokenKey(token);
        AccessTokenWithBLOBs accessTokenDo = getAccessTokenDo(key);
        if(accessTokenDo!=null){
            try {
                authentication = this.deserializeAuthentication(accessTokenDo.getAuthentication());
            } catch (IllegalArgumentException var5) {
                this.removeRefreshToken(key);
            }
        }
        return authentication;
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        String refreshToken = null;
        if(token.getRefreshToken() != null) {
            refreshToken = token.getRefreshToken().getValue();
        }

        if(this.readAccessToken(token.getValue()) != null) {
            this.removeAccessToken(token.getValue());
        }

        AccessTokenWithBLOBs accessToken = new AccessTokenWithBLOBs();
        accessToken.setTokenId(this.extractTokenKey(token.getValue()));
        accessToken.setToken(this.serializeAccessToken(token));
        accessToken.setAuthenticationId(this.authenticationKeyGenerator.extractKey(authentication));
        accessToken.setUserName(authentication.isClientOnly()?authentication.getName():"");
        accessToken.setClientId(authentication.getOAuth2Request().getClientId());
        accessToken.setAuthentication(this.serializeAuthentication(authentication));
        accessToken.setRefreshToken(this.extractTokenKey(refreshToken));
        accessTokenDao.insertSelective(accessToken);

    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        OAuth2AccessToken accessToken = null;
        String key = this.extractTokenKey(tokenValue);
        AccessTokenWithBLOBs accessTokenDo = getAccessTokenDo(key);
        if(accessTokenDo!=null){
            try {
                accessToken = this.deserializeAccessToken(accessTokenDo.getToken());
            }catch (IllegalArgumentException var5) {
                this.removeAccessToken(tokenValue);
            }
        }
        return accessToken;
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken oAuth2AccessToken) {
        this.removeAccessToken(oAuth2AccessToken.getValue());
    }
    public void removeAccessToken(String tokenValue) {
        AccessTokenQuery query = new AccessTokenQuery();
        String key = this.extractTokenKey(tokenValue);
        query.createCriteria().andTokenIdEqualTo(key);
        accessTokenDao.deleteByQuery(query);
    }
    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        RefreshTokenWithBLOBs refreshTokenDo = new RefreshTokenWithBLOBs();
        refreshTokenDo.setTokenId(this.extractTokenKey(refreshToken.getValue()));
        refreshTokenDo.setToken(this.serializeRefreshToken(refreshToken));
        refreshTokenDo.setAuthentication(this.serializeAuthentication(authentication));

        refreshTokenDao.insertSelective(refreshTokenDo);
    }

    @Override
    public OAuth2RefreshToken readRefreshToken(String token) {
        OAuth2RefreshToken refreshToken = null;

        String key = this.extractTokenKey(token);
        RefreshTokenWithBLOBs refreshTokenDo = getRefreshTokenDo(key);
        if(refreshTokenDo!=null) {
            try {
                refreshToken = this.deserializeRefreshToken(refreshTokenDo.getToken());
            } catch (IllegalArgumentException var5) {
                this.removeRefreshToken(token);
            }
        }
        return refreshToken;
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        return this.readAuthenticationForRefreshToken(token.getValue());
    }
    public OAuth2Authentication readAuthenticationForRefreshToken(String token) {
        OAuth2Authentication authentication = null;
        String key = this.extractTokenKey(token);
        RefreshTokenWithBLOBs refreshTokenDo = getRefreshTokenDo(key);
        if(refreshTokenDo!=null) {
            try {
                authentication = this.deserializeAuthentication(refreshTokenDo.getAuthentication());

            } catch (IllegalArgumentException var5) {
                this.removeRefreshToken(token);
            }
        }

        return authentication;
    }
    @Override
    public void removeRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {
        this.removeRefreshToken(oAuth2RefreshToken.getValue());
    }
    public void removeRefreshToken(String token) {
        RefreshTokenQuery query = new RefreshTokenQuery();
        String key = this.extractTokenKey(token);
        query.createCriteria().andTokenIdEqualTo(key);
        refreshTokenDao.deleteByQuery(query);
    }
    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {
        this.removeAccessTokenUsingRefreshToken(oAuth2RefreshToken.getValue());
    }
    public void removeAccessTokenUsingRefreshToken(String refreshToken) {
        AccessTokenQuery query = new AccessTokenQuery();
        String key = this.extractTokenKey(refreshToken);
        query.createCriteria().andRefreshTokenEqualTo(key);
        accessTokenDao.deleteByQuery(query);

    }
    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        OAuth2AccessToken accessToken = null;
        String key = this.authenticationKeyGenerator.extractKey(authentication);
        AccessTokenWithBLOBs accessTokenDo = getAccessTokenDo(key);

        if(accessTokenDo!=null) {
            accessToken = this.deserializeAccessToken(accessTokenDo.getToken());


            if (accessToken != null && !key.equals(this.authenticationKeyGenerator.extractKey(this.readAuthentication(accessToken.getValue())))) {
                this.removeAccessToken(accessToken.getValue());
                this.storeAccessToken(accessToken, authentication);
            }

        }
        return accessToken;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        List accessTokens = new ArrayList();

        AccessTokenQuery query = new AccessTokenQuery();
        query.createCriteria().andUserNameEqualTo(userName).andClientIdEqualTo(clientId);
        List<AccessTokenWithBLOBs> accessTokenWithBLOBses = accessTokenDao.selectByQueryWithBLOBs(query);
        for (AccessTokenWithBLOBs accessTokenDo : accessTokenWithBLOBses) {
            OAuth2AccessToken oAuth2AccessToken = this.deserializeAccessToken(accessTokenDo.getToken());
            if(oAuth2AccessToken!=null){
                accessTokens.add(oAuth2AccessToken);
            }
        }
        return accessTokens;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        List accessTokens = new ArrayList();

        AccessTokenQuery query = new AccessTokenQuery();
        query.createCriteria().andClientIdEqualTo(clientId);
        List<AccessTokenWithBLOBs> accessTokenWithBLOBses = accessTokenDao.selectByQueryWithBLOBs(query);
        for (AccessTokenWithBLOBs accessTokenDo : accessTokenWithBLOBses) {
            OAuth2AccessToken oAuth2AccessToken = this.deserializeAccessToken(accessTokenDo.getToken());
            if(oAuth2AccessToken!=null){
                accessTokens.add(oAuth2AccessToken);
            }
        }
        return accessTokens;
    }

    protected String extractTokenKey(String value) {
        if(value == null) {
            return null;
        } else {
            MessageDigest digest;
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException var5) {
                throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
            }

            try {
                byte[] e = digest.digest(value.getBytes("UTF-8"));
                return String.format("%032x", new Object[]{new BigInteger(1, e)});
            } catch (UnsupportedEncodingException var4) {
                throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
            }
        }
    }


    protected byte[] serializeAccessToken(OAuth2AccessToken token) {
        return SerializationUtils.serialize(token);
    }

    protected byte[] serializeRefreshToken(OAuth2RefreshToken token) {
        return SerializationUtils.serialize(token);
    }

    protected byte[] serializeAuthentication(OAuth2Authentication authentication) {
        return SerializationUtils.serialize(authentication);
    }

    protected OAuth2AccessToken deserializeAccessToken(byte[] token) {
        return (OAuth2AccessToken)SerializationUtils.deserialize(token);
    }

    protected OAuth2RefreshToken deserializeRefreshToken(byte[] token) {
        return (OAuth2RefreshToken)SerializationUtils.deserialize(token);
    }

    protected OAuth2Authentication deserializeAuthentication(byte[] authentication) {
        return (OAuth2Authentication)SerializationUtils.deserialize(authentication);
    }

    protected AccessTokenWithBLOBs getAccessTokenDo(String token){
        AccessTokenWithBLOBs accessToken = null;
        if(StringUtils.isNotBlank(token)) {
            AccessTokenQuery query = new AccessTokenQuery();
            query.createCriteria().andTokenIdEqualTo(token);
            List<AccessTokenWithBLOBs> accessTokenDos = accessTokenDao.selectByQueryWithBLOBs(query);
            if (CollectionUtils.isNotEmpty(accessTokenDos)) {
                accessToken = accessTokenDos.get(0);
            }
        }
        return accessToken;
    }
    protected RefreshTokenWithBLOBs getRefreshTokenDo(String token){
        RefreshTokenWithBLOBs refreshToken = null;
        if(StringUtils.isNotBlank(token)) {
            RefreshTokenQuery query = new RefreshTokenQuery();
            query.createCriteria().andTokenIdEqualTo(token);
            List<RefreshTokenWithBLOBs> refreshTokens = refreshTokenDao.selectByQueryWithBLOBs(query);
            if (CollectionUtils.isNotEmpty(refreshTokens)) {
                refreshToken = refreshTokens.get(0);
            }
        }
        return refreshToken;
    }
}
