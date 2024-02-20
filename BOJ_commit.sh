#!/bin/bash

echo '===== BOJ_commit.sh start ====='

rootDir=/home/dding/algorithm/Algorithm_BOJ-java
cd $rootDir
echo pwd = `pwd`

# bring the latest
git pull

# get file's path to commit
filePath=`git status -u -s | head -n 1`
filePath=${filePath:3}
echo filePath = $filePath

# Exit if file does not exist
if [ -z "$filePath" ]; then
	echo "===== file does not exist ====="
	echo "===== BOJ.commit.sh end ====="
	exit
fi

# get dirPath
dirPath=`dirname $filePath`
echo dirPath = $dirPath

# get file's name
fileName=`basename $filePath`
echo fileName = $fileName

# Generate commit message
commitMessageTitle=$(echo $dirPath | cut -d '\' -f 3)
commitMessageBody="commit-time: `date`"
commitMessage="$commitMessageTitle"$'\n'"$commitMessageBody"
echo commitMessage = $commitMessage

# git commit
cd $dirPath
git add $fileName
git commit -m "$commitMessage"
git push origin master

echo "===== BOJ_commit.sh end ====="
