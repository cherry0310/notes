# git命令
>  git checkout -b develop master

基于主分支创建develop分支

> git checkout master

切换到主分支

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
