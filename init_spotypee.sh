#!/bin/bash
RESULT_FOLDER="spotypee_build"
YOCTO_VERSION="honister"
GIT_YOCTO="git://git.yoctoproject.org/poky.git"
GIT_OPENEMBEDDED="git://git.openembedded.org/meta-openembedded"
GIT_RASPBERRYPI="git://git.yoctoproject.org/meta-raspberrypi"
GIT_SECURITY="git://git.yoctoproject.org/meta-security.git"

GIT_REPOS=("$GIT_OPENEMBEDDED" "$GIT_RASPBERRYPI" "$GIT_SECURITY")

git clone --branch $YOCTO_VERSION $GIT_YOCTO $RESULT_FOLDER

cd $RESULT_FOLDER
for git_repo in "${GIT_REPOS[@]}";
do
	echo $git_repo
	git clone --branch $YOCTO_VERSION $git_repo
done

rm -rf meta-poky
rm -rf meta-yocto-bsp
rm -rf meta-selftest

cp -r ../meta-rpi-config .

#Set TEMPLATECONF
printf $'# Template settings\n' > .templateconf
printf $'TEMPLATECONF=${TEMPLATECONF:-meta-rpi-config/conf/samples}\n' >> .templateconf

#Change default path ##OEROOT##
sed -i "s|##OEROOT##|${PWD}|g" meta-rpi-config/conf/samples/bblayers.conf.sample
