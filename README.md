# 天津外贸综合服务平台

## 模块介绍

|模块名|说明|
|-----|----|
|ftisp-front|前端工程|
|ftisp-web|后端工程|



## 检出代码命令

```
git clone --recursive https://dev.gie360.com/git/dev/ftisp.git
cd ftisp
git submodule foreach git checkout master
```

## 其他命令
- 保存密码： `git config --global  credential.helper store`
- 初始化子模块：`git submodule init`
- 更新子模块：`git submodule update`
- 强制更新子模块：`git submodule foreach git pull `
