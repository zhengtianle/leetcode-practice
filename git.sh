#!/bin/bash
cd /home/zhengtianle/workspace/idea-workspace/LeetCodePractice
echo "-------------------add commit pull push 一步到位："
git add .
git status
read -p "输入commit注释：" input
if [ -n "${input}" ]
then
    git commit -m "${input}"
    git pull
    echo "正在拉取最新分支"
    git status
    git push origin master
else
    read -p "您没有输入commit注释，是否重新运行此脚本 y/n？" choice
    if [ ${choice}x = "y" ]
    then
        ./git.sh
    fi
fi
