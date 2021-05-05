## aurora-mall	极光商城

[![](https://img.shields.io/badge/%E5%BC%80%E5%8F%91%E8%BF%9B%E5%BA%A6-%E5%BC%80%E5%8F%91%E4%B8%AD-brightgreen?style=flat-square)]() [![](https://img.shields.io/badge/license-MIT-green?style=flat-square)](https://github.com/besscroft/SpringCloud-mall/blob/master/LICENSE) [![](https://img.shields.io/badge/release-v0.0.1-orange?style=flat-square)]()

### 简介

aurora-mall 是一个微服务商城项目，我做这个项目的目的就是为了以`项目驱动学习`，其中也参考了不少大佬的项目，同时查阅了大量文档和资料，也在看不少的书 。我一直有写作的习惯（不仅限于博客），如果在练习这个项目的同时，还能够整理出相关的学习笔记那是再好不过了😀**目前还在开发中！**

### 预览地址

预计每周末更新预览版本

https://mall.aurora.besscroft.com/

> 服务器有点拉跨，求大佬放过~~~

### TODO

- [ ] 管理平台订单模块的实现。
- [ ] 管理平台商品模块的实现。
- [x]  权限管理系统模块的实现。

## 技术选型

### 后端技术

* [Spring Cloud](https://spring.io/projects/spring-cloud) && [Spring Cloud Alibaba](https://spring.io/projects/spring-cloud-alibaba) && [Spring Cloud Security](https://spring.io/projects/spring-cloud-security)
* [MyBatis](https://mybatis.org/mybatis-3/zh/index.html) && [MyBatis-Plus](https://baomidou.com/) && [PageHelper](https://pagehelper.github.io/) && [Druid](https://github.com/alibaba/druid)
* [guava](https://github.com/google/guava) && [HuTool](https://www.hutool.cn/docs/#/) && [lombok](https://projectlombok.org/) && [spring-data-commons](https://github.com/spring-projects/spring-data-commons) && [commons-lang3](https://commons.apache.org/proper/commons-lang/)
* [knife4j](https://doc.xiaominfo.com/knife4j/)
* [nacos](https://nacos.io/zh-cn/docs/what-is-nacos.html) && redis && mysql
* [nimbus-jose-jwt](https://bitbucket.org/connect2id/nimbus-jose-jwt/src/master/) && [jwt](https://github.com/jwtk/jjwt)

### 部署/运维

* [Docker](https://www.docker.com/)
* [Portainer](https://github.com/portainer/portainer)
* [Jenkins](https://github.com/jenkinsci/jenkins)

### 前端技术

* [Vue](https://vuejs.org/)
* [element-ui](https://element.eleme.io/)
* [Axios](https://github.com/axios/axios)
* [vue-element-admin](https://panjiachen.github.io/vue-element-admin-site/zh/)


## 环境搭建

### 开发环境

* JDK 1.8
* Idea 2020.3.1
* [nodejs](https://nodejs.org/dist/latest-v12.x/) v12.20.1

### 行为准则

我们有一份 [行为准则](https://github.com/besscroft/aurora-mall/blob/main/CODE_OF_CONDUCT.md)，希望所有的贡献者都能遵守，请花时间阅读一遍全文以确保你能明白哪些是可以做的，哪些是不可以做的。

### 代码贡献

我们有一份 [开源代码贡献小册](https://github.com/besscroft/aurora-mall/blob/main/fork-and-push.md) ，如果你还不会，可以看一下大概的思路，如果你已经会了，那么更好。

### 在线开发

你可以使用 Gitpod 进行在线开发：

<p><a href="https://gitpod.io/#https://github.com/besscroft/aurora-mall" rel="nofollow"><img src="https://camo.githubusercontent.com/1eb1ddfea6092593649f0117f7262ffa8fbd3017/68747470733a2f2f676974706f642e696f2f627574746f6e2f6f70656e2d696e2d676974706f642e737667" alt="Open in Gitpod" data-canonical-src="https://gitpod.io/button/open-in-gitpod.svg" style="max-width:100%;"></a></p>

或者克隆到本地开发:

```
$ git clone https://github.com/besscroft/aurora-mall.git
```
### 项目构建（管理平台的前端）

其实我更推荐[yarn](https://github.com/yarnpkg/yarn)

```bash
# 克隆项目
git clone https://github.com/besscroft/aurora-mall.git

# 进入项目目录
cd aurora-mall/mall-web

# 安装依赖
npm install

# 建议不要用 cnpm 安装 会有各种诡异的bug 可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 本地开发 启动项目
npm run dev
```

#### 本项目的参考的项目（学到了不少思想）

[vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)
[mall](https://github.com/macrozheng/mall)
[RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue)

#### 联系我

电子邮件：besscroft@foxmail.com

QQ群：<a target="_blank" href="https://qm.qq.com/cgi-bin/qm/qr?k=QGRHYDL2XE46mQMgl54WtIUl5pSuHVKP&jump_from=webapi"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="GitGitGo" title="GitGitGo"></a>

如果您有任何建议，欢迎反馈！