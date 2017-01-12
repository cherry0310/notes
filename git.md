# git命令
>  git checkout -b develop master

基于主分支创建develop分支

> git checkout master

切换到主分支

> git push --set-upstream origin develop

将本地的分支关联到远程中的develop分支，这样就可以直接git push了

> git merge --no-ff develop

把develop分支上的修改合并到主分支
* 不用--no-ff，git执行快进式合并，master分支直接指向develop分支
* 使用--no-ff，git执行正常合并，在master分支上生成新节点

> git checkout -b feature-x develop

基于develop分支建立功能分支x

> git branch -d feature-x

删除功能分支

> git clone https://github.com/cherry0310/notes.git

克隆github上的项目到本地

> git add .

> git add -A

添加修改

> git commit -m "init"

提交修改

> git push

将本地分支更新推送到远程主机

> git diff

查看版本之间的变动

> git branch

> git branch -a

查看本地分支/查看所有分支

> git push origin --delete cherry0310-patch-1

删除远程分支
