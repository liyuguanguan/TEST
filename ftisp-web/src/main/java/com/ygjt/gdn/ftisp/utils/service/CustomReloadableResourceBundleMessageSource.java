package com.ygjt.gdn.ftisp.utils.service;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Assert;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.ServletContextResourceLoader;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.*;

/**
 * Created by Je on 2016/11/16.
 * custom ReloadableResourceBundleMessageSource
 * 加载所有message，合并同名文件
 */
public class CustomReloadableResourceBundleMessageSource extends AbstractMessageSource implements ResourceLoaderAware {

    private static final Logger logger = Logger.getLogger(CustomReloadableResourceBundleMessageSource.class);
    private static final String   PROPERTIES_SUFFIX = ".properties";
    private static final String   XML_SUFFIX        = ".xml";
    private              String[] basenames         = new String[0];
    private String     defaultEncoding;
    private Properties fileEncodings;
    private       boolean                                                             fallbackToSystemLocale = true;
    private       long                                                                cacheMillis            = -1L;
    private       PropertiesPersister                                                 propertiesPersister    = new DefaultPropertiesPersister();
    private       ResourcePatternResolver                                             resourceLoader         = new PathMatchingResourcePatternResolver();
    private final Map<String, Map<Locale, List<String>>>                              cachedFilenames        = new HashMap();
    private final Map<String, PropertiesHolder> cachedProperties       = new HashMap();
    private final Map<Locale, PropertiesHolder> cachedMergedProperties = new HashMap();

    @Autowired(required = false)
    private ServletContext servletContext;

    public CustomReloadableResourceBundleMessageSource() {

    }
    public void setLoadWebResource(boolean loadWebResource){
        if(loadWebResource && servletContext !=null){
            resourceLoader = new PathMatchingResourcePatternResolver(new ServletContextResourceLoader(servletContext));
        }else{
            resourceLoader = new PathMatchingResourcePatternResolver();
        }
    }

    public void setBasename(String basename) {
        this.setBasenames(new String[]{basename});
    }



    public void setBasenames(String... basenames) {
        if (basenames != null) {
            this.basenames = new String[basenames.length];

            for (int i = 0; i < basenames.length; ++i) {
                String basename = basenames[i];
                Assert.hasText(basename, "Basename must not be empty");
                this.basenames[i] = basename.trim();
            }
        } else {
            this.basenames = new String[0];
        }

    }

    public void setDefaultEncoding(String defaultEncoding) {
        this.defaultEncoding = defaultEncoding;
    }

    public void setFileEncodings(Properties fileEncodings) {
        this.fileEncodings = fileEncodings;
    }

    public void setFallbackToSystemLocale(boolean fallbackToSystemLocale) {
        this.fallbackToSystemLocale = fallbackToSystemLocale;
    }

    public void setCacheSeconds(int cacheSeconds) {
        this.cacheMillis = (long) (cacheSeconds * 1000);
    }

    public void setPropertiesPersister(PropertiesPersister propertiesPersister) {
        this.propertiesPersister = (PropertiesPersister) (propertiesPersister != null ? propertiesPersister : new DefaultPropertiesPersister());
    }

    public void setResourceLoader(ResourcePatternResolver resourceLoader) {
        this.resourceLoader = (ResourcePatternResolver) (resourceLoader != null ? resourceLoader : new PathMatchingResourcePatternResolver());
    }

    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        if (this.cacheMillis < 0L) {
            PropertiesHolder arr$ = this.getMergedProperties(locale);
            String len$ = arr$.getProperty(code);
            if (len$ != null) {
                return len$;
            }
        } else {
            String[] var12 = this.basenames;
            int var13 = var12.length;

            for (int i$ = 0; i$ < var13; ++i$) {
                String basename = var12[i$];
                List filenames = this.calculateAllFilenames(basename, locale);
                Iterator i$1 = filenames.iterator();

                while (i$1.hasNext()) {
                    String filename = (String) i$1.next();
                    PropertiesHolder propHolder = this.getProperties(filename);
                    String result = propHolder.getProperty(code);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }

        return null;
    }

    protected MessageFormat resolveCode(String code, Locale locale) {
        if (this.cacheMillis < 0L) {
            PropertiesHolder arr$ = this.getMergedProperties(locale);
            MessageFormat len$ = arr$.getMessageFormat(code, locale);
            if (len$ != null) {
                return len$;
            }
        } else {
            String[] var12 = this.basenames;
            int var13 = var12.length;

            for (int i$ = 0; i$ < var13; ++i$) {
                String basename = var12[i$];
                List filenames = this.calculateAllFilenames(basename, locale);
                Iterator i$1 = filenames.iterator();

                while (i$1.hasNext()) {
                    String filename = (String) i$1.next();
                    PropertiesHolder propHolder = this.getProperties(filename);
                    MessageFormat result = propHolder.getMessageFormat(code, locale);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }

        return null;
    }

    protected PropertiesHolder getMergedProperties(Locale locale) {
        this.logger.debug("gdn_i18n: getMergedProperties for locale [" + locale.toString() + "]");
        Map var2 = this.cachedMergedProperties;
        synchronized (this.cachedMergedProperties) {
            PropertiesHolder mergedHolder = (PropertiesHolder) this.cachedMergedProperties.get(locale);
            if (mergedHolder != null) {
                return mergedHolder;
            } else {
                Properties mergedProps = new Properties();
                mergedHolder = new PropertiesHolder(mergedProps, -1L);

                for (int i = this.basenames.length - 1; i >= 0; --i) {
                    List filenames = this.calculateAllFilenames(this.basenames[i], locale);

                    for (int j = filenames.size() - 1; j >= 0; --j) {
                        String filename = (String) filenames.get(j);
                        PropertiesHolder propHolder = this.getProperties(filename);
                        if (propHolder!=null && propHolder.getProperties() != null) {
                            mergedProps.putAll(propHolder.getProperties());
                        }
                    }
                }

                this.cachedMergedProperties.put(locale, mergedHolder);
                return mergedHolder;
            }
        }
    }

    protected List<String> calculateAllFilenames(String basename, Locale locale) {
        Map var3 = this.cachedFilenames;
        synchronized (this.cachedFilenames) {
            Map localeMap = (Map) this.cachedFilenames.get(basename);
            if (localeMap != null) {
                List filenames = (List) localeMap.get(locale);
                if (filenames != null) {
                    return filenames;
                }
            }

            ArrayList filenames1 = new ArrayList(7);
            filenames1.addAll(this.calculateFilenamesForLocale(basename, locale));
            if (this.fallbackToSystemLocale && !locale.equals(Locale.getDefault())) {
                List fallbackFilenames = this.calculateFilenamesForLocale(basename, Locale.getDefault());
                Iterator i$ = fallbackFilenames.iterator();

                while (i$.hasNext()) {
                    String fallbackFilename = (String) i$.next();
                    if (!filenames1.contains(fallbackFilename)) {
                        filenames1.add(fallbackFilename);
                    }
                }
            }

            filenames1.add(basename);
            if (localeMap != null) {
                localeMap.put(locale, filenames1);
            } else {
                HashMap localeMap1 = new HashMap();
                localeMap1.put(locale, filenames1);
                this.cachedFilenames.put(basename, localeMap1);
            }
            this.logger.debug("gdn_i18n:calculateAllFilenames: [" + org.apache.commons.lang.StringUtils.join(filenames1.toArray(),"/") + "]");
            return filenames1;
        }
    }

    protected List<String> calculateFilenamesForLocale(String basename, Locale locale) {
        ArrayList result = new ArrayList(3);
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        StringBuilder temp = new StringBuilder(basename);
        temp.append('_');
        if (language.length() > 0) {
            temp.append(language);
            result.add(0, temp.toString());
        }

        temp.append('_');
        if (country.length() > 0) {
            temp.append(country);
            result.add(0, temp.toString());
        }

        if (variant.length() > 0 && (language.length() > 0 || country.length() > 0)) {
            temp.append('_').append(variant);
            result.add(0, temp.toString());
        }

        return result;
    }

    protected PropertiesHolder getProperties(String filename) {
        Map var2 = this.cachedProperties;
        synchronized (this.cachedProperties) {
            PropertiesHolder propHolder = (PropertiesHolder) this.cachedProperties.get(filename);
            return propHolder == null || propHolder.getRefreshTimestamp() >= 0L && propHolder.getRefreshTimestamp() <= System.currentTimeMillis() - this.cacheMillis ? this.refreshProperties(filename, propHolder) : propHolder;
        }
    }

    protected PropertiesHolder refreshProperties(String filename, PropertiesHolder propHolder) {
        long refreshTimestamp = this.cacheMillis < 0L ? -1L : System.currentTimeMillis();
        try {
            Resource[] resources = this.resourceLoader.getResources(filename + ".properties");

            this.logger.debug("gdn_i18n: Loading properties for filename [" + filename + "]");
            for (Resource resource : resources) {


                if (resource.exists()) {
                    long fileTimestamp = -1L;
                    if (this.cacheMillis >= 0L) {
                        try {
                            fileTimestamp = resource.lastModified();
                            if (propHolder != null && propHolder.getFileTimestamp() == fileTimestamp) {
                                if (this.logger.isDebugEnabled()) {
                                    this.logger.debug("Re-caching properties for filename [" + filename + "] - file hasn\'t been modified");
                                }

                                propHolder.setRefreshTimestamp(refreshTimestamp);
                                return propHolder;
                            }
                        } catch (IOException var10) {
                            if (this.logger.isDebugEnabled()) {
                                this.logger.debug(resource + " could not be resolved in the file system - assuming that is hasn\'t changed", var10);
                            }

                            fileTimestamp = -1L;
                        }
                    }

                    try {
                        Properties ex = this.loadProperties(resource, filename);
                        propHolder = new PropertiesHolder(ex, fileTimestamp);
                    } catch (IOException var9) {
                        if (this.logger.isEnabledFor(Priority.WARN)) {
                            this.logger.warn("Could not parse properties file [" + resource.getFilename() + "]", var9);
                        }

                        propHolder = new PropertiesHolder();
                    }
                } else {
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("No properties file found for [" + filename + "] - neither plain properties nor XML");
                    }

                    propHolder = new PropertiesHolder();
                }

                propHolder.setRefreshTimestamp(refreshTimestamp);
                if(propHolder!=null && propHolder.getProperties()!=null && propHolder.getProperties().size()>0) {
                    if (this.cachedProperties.containsKey(filename)) {
                        PropertiesHolder propertiesHolder = this.cachedProperties.get(filename);
                        propHolder.putAllProperties(propertiesHolder.getProperties());
                    }

                    this.cachedProperties.put(filename, propHolder);
                    this.logger.debug("gdn_i18n: Loaded properties for filename [" + filename + "] count:" + propHolder.getProperties() != null ? propHolder.getProperties().size() : "0");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propHolder;
    }

    protected Properties loadProperties(Resource resource, String filename) throws IOException {
        InputStream is = resource.getInputStream();
        Properties props = new Properties();

        Properties encoding1;
        try {
            if (resource.getFilename().endsWith(".xml")) {
                this.logger.debug("gdn_i18n:loadProperties: Loading properties for filename [" + filename + "]");
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Loading properties [" + resource.getFilename() + "]");
                }

                this.propertiesPersister.loadFromXml(props, is);
            } else {
                String encoding = null;
                if (this.fileEncodings != null) {
                    encoding = this.fileEncodings.getProperty(filename);
                }

                if (encoding == null) {
                    encoding = this.defaultEncoding;
                }

                if (encoding != null) {
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Loading properties [" + resource.getFilename() + "] with encoding \'" + encoding + "\'");
                    }

                    this.propertiesPersister.load(props, new InputStreamReader(is, encoding));
                } else {
                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug("Loading properties [" + resource.getFilename() + "]");
                    }

                    this.propertiesPersister.load(props, is);
                }
            }

            encoding1 = props;
        } finally {
            is.close();
        }

        return encoding1;
    }

    public void clearCache() {
        this.logger.debug("Clearing entire resource bundle cache");
        Map var1 = this.cachedProperties;
        synchronized (this.cachedProperties) {
            this.cachedProperties.clear();
        }

        var1 = this.cachedMergedProperties;
        synchronized (this.cachedMergedProperties) {
            this.cachedMergedProperties.clear();
        }
    }

    public void clearCacheIncludingAncestors() {
        this.clearCache();
        if (this.getParentMessageSource() instanceof ReloadableResourceBundleMessageSource) {
            ((ReloadableResourceBundleMessageSource) this.getParentMessageSource()).clearCacheIncludingAncestors();
        }

    }

    public String toString() {
        return this.getClass().getName() + ": basenames=[" + StringUtils.arrayToCommaDelimitedString(this.basenames) + "]";
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    protected class PropertiesHolder {
        private Properties properties;
        private long fileTimestamp = -1L;
        private long refreshTimestamp = -1L;
        private final Map<String, Map<Locale, MessageFormat>> cachedMessageFormats = new HashMap();

        public PropertiesHolder(Properties properties, long fileTimestamp) {
            this.properties = properties;
            this.fileTimestamp = fileTimestamp;
        }

        public PropertiesHolder() {
        }

        public Properties getProperties() {
            return this.properties;
        }

        public long getFileTimestamp() {
            return this.fileTimestamp;
        }

        public void setRefreshTimestamp(long refreshTimestamp) {
            this.refreshTimestamp = refreshTimestamp;
        }

        public long getRefreshTimestamp() {
            return this.refreshTimestamp;
        }

        public String getProperty(String code) {
            return this.properties == null?null:this.properties.getProperty(code);
        }

        public void putAllProperties(Properties properties){
            this.properties.putAll(properties);
        }

        public MessageFormat getMessageFormat(String code, Locale locale) {
            if(this.properties == null) {
                return null;
            } else {
                Map var3 = this.cachedMessageFormats;
                synchronized(this.cachedMessageFormats) {
                    Map localeMap = (Map)this.cachedMessageFormats.get(code);
                    if(localeMap != null) {
                        MessageFormat msg = (MessageFormat)((Map)localeMap).get(locale);
                        if(msg != null) {
                            return msg;
                        }
                    }

                    String msg1 = this.properties.getProperty(code);
                    if(msg1 != null) {
                        if(localeMap == null) {
                            localeMap = new HashMap();
                            this.cachedMessageFormats.put(code, localeMap);
                        }

                        MessageFormat result = createMessageFormat(msg1, locale);
                        ((Map)localeMap).put(locale, result);
                        return result;
                    } else {
                        return null;
                    }
                }
            }
        }
        protected MessageFormat createMessageFormat(String msg, Locale locale) {
            return new MessageFormat(msg != null?msg:"", locale);
        }
    }
}

