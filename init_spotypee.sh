#!/bin/bash
RESULT_FOLDER="spotypee_build"
YOCTO_VERSION="whinlatter"
BITBAKE_VERSION="2.16"
GIT_BITBAKE="https://git.openembedded.org/bitbake"
GIT_OPENEMBEDDED_CORE="https://git.openembedded.org/openembedded-core"
GIT_OPENEMBEDDED="git://git.openembedded.org/meta-openembedded"
GIT_RASPBERRYPI="git://git.yoctoproject.org/meta-raspberrypi"
GIT_SECURITY="git://git.yoctoproject.org/meta-security.git"

GIT_REPOS=("$GIT_OPENEMBEDDED_CORE" "$GIT_OPENEMBEDDED" "$GIT_RASPBERRYPI" "$GIT_SECURITY")

if [ -d "$RESULT_FOLDER" ]; then
  rm -rf "$RESULT_FOLDER"
fi
mkdir "$RESULT_FOLDER"
cd "$RESULT_FOLDER"

git clone --branch "$BITBAKE_VERSION" "$GIT_BITBAKE"

for git_repo in "${GIT_REPOS[@]}";
do
  echo "$git_repo"
  git clone --branch "$YOCTO_VERSION" "$git_repo"
done

cp -r ../meta-rpi-config .

#Set TEMPLATECONF
printf $'# Template settings\n' > .templateconf
echo "TEMPLATECONF=$PWD/meta-rpi-config/conf/templates/default" >> .templateconf

#Change default path ##OEROOT##
sed -i "s|##OEROOT##|${PWD}|g" meta-rpi-config/conf/templates/default/bblayers.conf.sample
