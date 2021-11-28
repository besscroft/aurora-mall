## aurora-mall	极光商城

[![](https://img.shields.io/badge/%E5%BC%80%E5%8F%91%E8%BF%9B%E5%BA%A6-%E5%BC%80%E5%8F%91%E4%B8%AD-brightgreen?style=flat-square)]() [![](https://img.shields.io/badge/license-MIT-green?style=flat-square)](https://github.com/besscroft/aurora-mall/blob/master/LICENSE) [![](https://img.shields.io/badge/release-v0.1.0-orange?style=flat-square)]() ![GitHub repo size](https://img.shields.io/github/repo-size/besscroft/aurora-mall?style=flat-square&color=328657)

### 简介

aurora-mall 是一个微服务商城项目，我做这个项目的目的就是为了以`项目驱动学习`，其中也参考了不少大佬的项目，同时查阅了大量文档和资料，也在看不少的书 。我一直有写作的习惯（不仅限于博客），如果在练习这个项目的同时，还能够整理出相关的学习笔记那是再好不过了😀**目前还在开发中！**

### 预览地址

[演示站](https://mall.aurora.besscroft.com/) 预计每周末更新 `dev` 分支最新源码。

```
账号：admin
密码：666666
```
## 文档

> 我们安装，我们更新，我们开发

[aurora-mall 的文档](https://mall.doc.besscroft.com/)，在这里你可以找到大部分问题的解答。

## 环境搭建

### 开发环境

aurora-mall 的需要以下程序才能正常的安装和运行：

- Git
- MySQL 5.x
- open/oracleJDK1.8+
- nacos 1.4.1+
- redis 6.0+
- nginx 1.16+
- elasticsearch 7+

aurora-mall 支持安装在 LNMP、宝塔面板 等集成环境中, Docker、HeroKu 等容器环境中, 支持大部分能够运行 Java 的平台。
安装教程请参阅 [文档](https://mall.doc.besscroft.com/)。

### 行为准则

我们有一份 [行为准则](https://github.com/besscroft/aurora-mall/blob/main/CODE_OF_CONDUCT.md)，希望所有的贡献者都能遵守，请花时间阅读一遍全文以确保你能明白哪些是可以做的，哪些是不可以做的。

### 代码贡献

[提出新想法 & 提交 Bug](https://github.com/besscroft/aurora-mall/issues/new) | [Fork & Pull Request](https://github.com/besscroft/aurora-mall/fork)

aurora-mall 欢迎各种贡献，包括但不限于改进，新功能，文档和代码改进，问题和错误报告。

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

#### 联系我

电子邮件：besscroft@foxmail.com

QQ群：<a target="_blank" href="https://qm.qq.com/cgi-bin/qm/qr?k=QGRHYDL2XE46mQMgl54WtIUl5pSuHVKP&jump_from=webapi"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="GitGitGo" title="GitGitGo"></a>

如果您有任何建议，欢迎反馈！

我将预览站部署在了 `DigitalOcean` ，如果你愿意走我的邀请链接注册，可以获得100美元的信用额度。

<a href="https://www.digitalocean.com/?refcode=6841be7284cc&utm_campaign=Referral_Invite&utm_medium=Referral_Program&utm_source=badge"><img src="https://web-platforms.sfo2.cdn.digitaloceanspaces.com/WWW/Badge%201.svg" alt="DigitalOcean Referral Badge" /></a>
