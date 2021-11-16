# git备忘录

## 1.SSH key

下载git之后，在你想要下载仓库的文件夹，右键git gui，生成一串key用于在GitHub的setting中进行添加（通过这一步，才能让你顺利的从GitHub上clone下来项目）

## 2.下载

以我这里的仓库为例子，在新文件夹处右键，使用git bash

![image-20211117013239267](git%E6%89%8B%E5%86%8C.assets/image-20211117013239267.png)

git bash中输入：

```bash
git clone https://github.com/lips0127/Leetcode-notes.git
```

## 3.上传

在clone下来的文件中添加你的修改的内容

```bash
git add .
git commit -m "本次修改的内容“
git push
```

ps.可能会提示你表明你的邮箱和用户名，以便仓库作者同你联系。