FROM ubuntu:22.04
LABEL maintainer "gogrit01@hs-esslingen.de"
LABEL description "Container to build yocto images"

RUN apt-get update && \
    apt-get install -y python3 python3-distutils build-essential zstd chrpath cpio diffstat file gawk git lz4 wget locales locales-all && \
    apt-get -y clean && \
    apt-get autoremove

RUN useradd -m yocto
RUN mkdir /home/yocto/yocto
RUN chown yocto:users /home/yocto/yocto 