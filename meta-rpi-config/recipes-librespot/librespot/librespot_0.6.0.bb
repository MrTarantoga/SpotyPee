inherit cargo

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get librespot could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/librespot/v0.6.0"
SRC_URI += "git://github.com/librespot-org/librespot.git;protocol=https;nobranch=1"
SRCREV = "383a6f6969f23b3e3cbc693747101cb9c92463dc"

S = "${WORKDIR}/git"

CARGO_SRC_DIR = ""
CARGO_BUILD_FLAGS:append = " --no-default-features --features with-libmdns --features pulseaudio-backend"

DEPENDS = "\
    pulseaudio \
    avahi-libnss-mdns \
    bindgen-cli-native \
    virtual/libc \
"
RDEPENDS:${PN} = "\
    pulseaudio \
    avahi-libnss-mdns \
    ca-certificates \
"

export BINDGEN_EXTRA_CLANG_ARGS = "--sysroot=${STAGING_DIR_TARGET}"
do_compile[exported_vars] += "BINDGEN_EXTRA_CLANG_ARGS"


# please note if you have entries that do not begin with crate://
# you must change them to how that package can be fetched
SRC_URI += " \
    crate://crates.io/addr2line/0.24.2 \
    crate://crates.io/adler2/2.0.0 \
    crate://crates.io/aes/0.8.4 \
    crate://crates.io/aho-corasick/1.1.3 \
    crate://crates.io/alsa-sys/0.3.1 \
    crate://crates.io/alsa/0.9.1 \
    crate://crates.io/android-tzdata/0.1.1 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/anstream/0.6.17 \
    crate://crates.io/anstyle-parse/0.2.6 \
    crate://crates.io/anstyle-query/1.1.2 \
    crate://crates.io/anstyle-wincon/3.0.6 \
    crate://crates.io/anstyle/1.0.9 \
    crate://crates.io/anyhow/1.0.91 \
    crate://crates.io/arrayvec/0.7.6 \
    crate://crates.io/async-broadcast/0.7.1 \
    crate://crates.io/async-channel/2.3.1 \
    crate://crates.io/async-io/2.3.4 \
    crate://crates.io/async-lock/3.4.0 \
    crate://crates.io/async-process/2.3.0 \
    crate://crates.io/async-recursion/1.1.1 \
    crate://crates.io/async-signal/0.2.10 \
    crate://crates.io/async-task/4.7.1 \
    crate://crates.io/async-trait/0.1.83 \
    crate://crates.io/atomic-waker/1.1.2 \
    crate://crates.io/atomic_refcell/0.1.13 \
    crate://crates.io/autocfg/1.4.0 \
    crate://crates.io/aws-lc-rs/1.10.0 \
    crate://crates.io/aws-lc-sys/0.22.0 \
    crate://crates.io/backtrace/0.3.74 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/base64/0.21.7 \
    crate://crates.io/base64/0.22.1 \
    crate://crates.io/base64ct/1.6.0 \
    crate://crates.io/bindgen/0.69.5 \
    crate://crates.io/bindgen/0.70.1 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitflags/2.6.0 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/blocking/1.6.1 \
    crate://crates.io/bumpalo/3.16.0 \
    crate://crates.io/bytemuck/1.19.0 \
    crate://crates.io/byteorder/1.5.0 \
    crate://crates.io/bytes/1.8.0 \
    crate://crates.io/cc/1.1.31 \
    crate://crates.io/cesu8/1.1.0 \
    crate://crates.io/cexpr/0.6.0 \
    crate://crates.io/cfg-expr/0.17.0 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/cfg_aliases/0.2.1 \
    crate://crates.io/chrono/0.4.38 \
    crate://crates.io/cipher/0.4.4 \
    crate://crates.io/clang-sys/1.8.1 \
    crate://crates.io/cmake/0.1.51 \
    crate://crates.io/colorchoice/1.0.3 \
    crate://crates.io/combine/4.6.7 \
    crate://crates.io/concurrent-queue/2.5.0 \
    crate://crates.io/const-oid/0.9.6 \
    crate://crates.io/core-foundation-sys/0.8.7 \
    crate://crates.io/core-foundation/0.9.4 \
    crate://crates.io/coreaudio-rs/0.11.3 \
    crate://crates.io/coreaudio-sys/0.2.16 \
    crate://crates.io/cpal/0.15.3 \
    crate://crates.io/cpufeatures/0.2.14 \
    crate://crates.io/crossbeam-utils/0.8.20 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/ctr/0.9.2 \
    crate://crates.io/darling/0.20.10 \
    crate://crates.io/darling_core/0.20.10 \
    crate://crates.io/darling_macro/0.20.10 \
    crate://crates.io/dasp_sample/0.11.0 \
    crate://crates.io/data-encoding/2.6.0 \
    crate://crates.io/der/0.7.9 \
    crate://crates.io/deranged/0.3.11 \
    crate://crates.io/derive_builder/0.20.2 \
    crate://crates.io/derive_builder_core/0.20.2 \
    crate://crates.io/derive_builder_macro/0.20.2 \
    crate://crates.io/digest/0.10.7 \
    crate://crates.io/dns-sd/0.1.3 \
    crate://crates.io/dunce/1.0.5 \
    crate://crates.io/either/1.13.0 \
    crate://crates.io/encoding_rs/0.8.35 \
    crate://crates.io/endi/1.1.0 \
    crate://crates.io/enumflags2/0.7.10 \
    crate://crates.io/enumflags2_derive/0.7.10 \
    crate://crates.io/env_filter/0.1.2 \
    crate://crates.io/env_logger/0.11.5 \
    crate://crates.io/equivalent/1.0.1 \
    crate://crates.io/errno/0.3.9 \
    crate://crates.io/event-listener-strategy/0.5.2 \
    crate://crates.io/event-listener/5.3.1 \
    crate://crates.io/fastrand/2.1.1 \
    crate://crates.io/fixedbitset/0.4.2 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/form_urlencoded/1.2.1 \
    crate://crates.io/fs_extra/1.3.0 \
    crate://crates.io/futures-channel/0.3.31 \
    crate://crates.io/futures-core/0.3.31 \
    crate://crates.io/futures-executor/0.3.31 \
    crate://crates.io/futures-io/0.3.31 \
    crate://crates.io/futures-lite/2.4.0 \
    crate://crates.io/futures-macro/0.3.31 \
    crate://crates.io/futures-sink/0.3.31 \
    crate://crates.io/futures-task/0.3.31 \
    crate://crates.io/futures-timer/3.0.3 \
    crate://crates.io/futures-util/0.3.31 \
    crate://crates.io/futures/0.3.31 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getopts/0.2.21 \
    crate://crates.io/getrandom/0.2.15 \
    crate://crates.io/gimli/0.31.1 \
    crate://crates.io/gio-sys/0.20.5 \
    crate://crates.io/glib-macros/0.20.5 \
    crate://crates.io/glib-sys/0.20.5 \
    crate://crates.io/glib/0.20.5 \
    crate://crates.io/glob/0.3.1 \
    crate://crates.io/gobject-sys/0.20.4 \
    crate://crates.io/governor/0.6.3 \
    crate://crates.io/gstreamer-app-sys/0.23.2 \
    crate://crates.io/gstreamer-app/0.23.2 \
    crate://crates.io/gstreamer-audio-sys/0.23.2 \
    crate://crates.io/gstreamer-audio/0.23.2 \
    crate://crates.io/gstreamer-base-sys/0.23.2 \
    crate://crates.io/gstreamer-base/0.23.2 \
    crate://crates.io/gstreamer-sys/0.23.2 \
    crate://crates.io/gstreamer/0.23.2 \
    crate://crates.io/h2/0.3.26 \
    crate://crates.io/h2/0.4.6 \
    crate://crates.io/hashbrown/0.15.0 \
    crate://crates.io/headers-core/0.3.0 \
    crate://crates.io/headers/0.4.0 \
    crate://crates.io/heck/0.5.0 \
    crate://crates.io/hermit-abi/0.3.9 \
    crate://crates.io/hermit-abi/0.4.0 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hmac/0.12.1 \
    crate://crates.io/home/0.5.9 \
    crate://crates.io/hostname/0.4.0 \
    crate://crates.io/http-body-util/0.1.2 \
    crate://crates.io/http-body/0.4.6 \
    crate://crates.io/http-body/1.0.1 \
    crate://crates.io/http/0.2.12 \
    crate://crates.io/http/1.1.0 \
    crate://crates.io/httparse/1.9.5 \
    crate://crates.io/httpdate/1.0.3 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/hyper-proxy2/0.1.0 \
    crate://crates.io/hyper-rustls/0.24.2 \
    crate://crates.io/hyper-rustls/0.26.0 \
    crate://crates.io/hyper-rustls/0.27.3 \
    crate://crates.io/hyper-util/0.1.10 \
    crate://crates.io/hyper/0.14.31 \
    crate://crates.io/hyper/1.5.0 \
    crate://crates.io/iana-time-zone-haiku/0.1.2 \
    crate://crates.io/iana-time-zone/0.1.61 \
    crate://crates.io/ident_case/1.0.1 \
    crate://crates.io/idna/0.5.0 \
    crate://crates.io/if-addrs/0.12.0 \
    crate://crates.io/indexmap/2.6.0 \
    crate://crates.io/inout/0.1.3 \
    crate://crates.io/ipnet/2.10.1 \
    crate://crates.io/is_terminal_polyfill/1.70.1 \
    crate://crates.io/itertools/0.12.1 \
    crate://crates.io/itertools/0.13.0 \
    crate://crates.io/itoa/1.0.11 \
    crate://crates.io/jack-sys/0.5.1 \
    crate://crates.io/jack/0.11.4 \
    crate://crates.io/jni-sys/0.3.0 \
    crate://crates.io/jni/0.21.1 \
    crate://crates.io/jobserver/0.1.32 \
    crate://crates.io/js-sys/0.3.72 \
    crate://crates.io/lazy_static/1.5.0 \
    crate://crates.io/lazycell/1.3.0 \
    crate://crates.io/libc/0.2.161 \
    crate://crates.io/libloading/0.7.4 \
    crate://crates.io/libloading/0.8.5 \
    crate://crates.io/libm/0.2.11 \
    crate://crates.io/libmdns/0.9.1 \
    crate://crates.io/libpulse-binding/2.28.1 \
    crate://crates.io/libpulse-simple-binding/2.28.1 \
    crate://crates.io/libpulse-simple-sys/1.21.1 \
    crate://crates.io/libpulse-sys/1.21.0 \
    crate://crates.io/linux-raw-sys/0.4.14 \
    crate://crates.io/lock_api/0.4.12 \
    crate://crates.io/log/0.4.22 \
    crate://crates.io/mach2/0.4.2 \
    crate://crates.io/memchr/2.7.4 \
    crate://crates.io/memoffset/0.9.1 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/minimal-lexical/0.2.1 \
    crate://crates.io/miniz_oxide/0.8.0 \
    crate://crates.io/mio/1.0.2 \
    crate://crates.io/mirai-annotations/1.12.0 \
    crate://crates.io/muldiv/1.0.1 \
    crate://crates.io/multimap/0.10.0 \
    crate://crates.io/ndk-context/0.1.1 \
    crate://crates.io/ndk-sys/0.5.0+25.2.9519653 \
    crate://crates.io/ndk/0.8.0 \
    crate://crates.io/nix/0.29.0 \
    crate://crates.io/no-std-compat/0.4.1 \
    crate://crates.io/nom/7.1.3 \
    crate://crates.io/nonzero_ext/0.3.0 \
    crate://crates.io/ntapi/0.4.1 \
    crate://crates.io/num-bigint-dig/0.8.4 \
    crate://crates.io/num-bigint/0.4.6 \
    crate://crates.io/num-conv/0.1.0 \
    crate://crates.io/num-derive/0.3.3 \
    crate://crates.io/num-derive/0.4.2 \
    crate://crates.io/num-integer/0.1.46 \
    crate://crates.io/num-iter/0.1.45 \
    crate://crates.io/num-rational/0.4.2 \
    crate://crates.io/num-traits/0.2.19 \
    crate://crates.io/num_enum/0.7.3 \
    crate://crates.io/num_enum_derive/0.7.3 \
    crate://crates.io/num_threads/0.1.7 \
    crate://crates.io/oauth2/4.4.2 \
    crate://crates.io/object/0.36.5 \
    crate://crates.io/oboe-sys/0.6.1 \
    crate://crates.io/oboe/0.6.1 \
    crate://crates.io/ogg/0.9.1 \
    crate://crates.io/once_cell/1.20.2 \
    crate://crates.io/openssl-probe/0.1.5 \
    crate://crates.io/option-operations/0.5.0 \
    crate://crates.io/ordered-stream/0.2.0 \
    crate://crates.io/parking/2.2.1 \
    crate://crates.io/parking_lot/0.12.3 \
    crate://crates.io/parking_lot_core/0.9.10 \
    crate://crates.io/paste/1.0.15 \
    crate://crates.io/pbkdf2/0.12.2 \
    crate://crates.io/pem-rfc7468/0.7.0 \
    crate://crates.io/percent-encoding/2.3.1 \
    crate://crates.io/petgraph/0.6.5 \
    crate://crates.io/pin-project-lite/0.2.15 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/piper/0.2.4 \
    crate://crates.io/pkcs1/0.7.5 \
    crate://crates.io/pkcs8/0.10.2 \
    crate://crates.io/pkg-config/0.3.31 \
    crate://crates.io/polling/3.7.3 \
    crate://crates.io/portable-atomic/1.9.0 \
    crate://crates.io/portaudio-rs/0.3.2 \
    crate://crates.io/portaudio-sys/0.1.1 \
    crate://crates.io/powerfmt/0.2.0 \
    crate://crates.io/ppv-lite86/0.2.20 \
    crate://crates.io/prettyplease/0.2.25 \
    crate://crates.io/priority-queue/2.1.1 \
    crate://crates.io/proc-macro-crate/3.2.0 \
    crate://crates.io/proc-macro2/1.0.89 \
    crate://crates.io/protobuf-codegen/3.7.1 \
    crate://crates.io/protobuf-parse/3.7.1 \
    crate://crates.io/protobuf-support/3.7.1 \
    crate://crates.io/protobuf/3.7.1 \
    crate://crates.io/quick-xml/0.36.2 \
    crate://crates.io/quote/1.0.37 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rand_distr/0.4.3 \
    crate://crates.io/redox_syscall/0.5.7 \
    crate://crates.io/regex-automata/0.4.8 \
    crate://crates.io/regex-syntax/0.8.5 \
    crate://crates.io/regex/1.11.1 \
    crate://crates.io/reqwest/0.11.27 \
    crate://crates.io/ring/0.17.8 \
    crate://crates.io/rodio/0.19.0 \
    crate://crates.io/rsa/0.9.6 \
    crate://crates.io/rustc-demangle/0.1.24 \
    crate://crates.io/rustc-hash/1.1.0 \
    crate://crates.io/rustix/0.38.38 \
    crate://crates.io/rustls-native-certs/0.7.3 \
    crate://crates.io/rustls-native-certs/0.8.0 \
    crate://crates.io/rustls-pemfile/1.0.4 \
    crate://crates.io/rustls-pemfile/2.2.0 \
    crate://crates.io/rustls-pki-types/1.10.0 \
    crate://crates.io/rustls-webpki/0.101.7 \
    crate://crates.io/rustls-webpki/0.102.8 \
    crate://crates.io/rustls/0.21.12 \
    crate://crates.io/rustls/0.22.4 \
    crate://crates.io/rustls/0.23.16 \
    crate://crates.io/rustversion/1.0.18 \
    crate://crates.io/ryu/1.0.18 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/schannel/0.1.26 \
    crate://crates.io/scopeguard/1.2.0 \
    crate://crates.io/sct/0.7.1 \
    crate://crates.io/sdl2-sys/0.37.0 \
    crate://crates.io/sdl2/0.37.0 \
    crate://crates.io/security-framework-sys/2.12.0 \
    crate://crates.io/security-framework/2.11.1 \
    crate://crates.io/serde/1.0.214 \
    crate://crates.io/serde_derive/1.0.214 \
    crate://crates.io/serde_json/1.0.132 \
    crate://crates.io/serde_path_to_error/0.1.16 \
    crate://crates.io/serde_repr/0.1.19 \
    crate://crates.io/serde_spanned/0.6.8 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/sha1/0.10.6 \
    crate://crates.io/sha2/0.10.8 \
    crate://crates.io/shannon/0.2.0 \
    crate://crates.io/shell-words/1.1.0 \
    crate://crates.io/shlex/1.3.0 \
    crate://crates.io/signal-hook-registry/1.4.2 \
    crate://crates.io/signature/2.2.0 \
    crate://crates.io/slab/0.4.9 \
    crate://crates.io/smallvec/1.13.2 \
    crate://crates.io/socket2/0.5.7 \
    crate://crates.io/spin/0.9.8 \
    crate://crates.io/spinning_top/0.3.0 \
    crate://crates.io/spki/0.7.3 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.11.1 \
    crate://crates.io/subtle/2.6.1 \
    crate://crates.io/symphonia-bundle-mp3/0.5.4 \
    crate://crates.io/symphonia-codec-vorbis/0.5.4 \
    crate://crates.io/symphonia-core/0.5.4 \
    crate://crates.io/symphonia-format-ogg/0.5.4 \
    crate://crates.io/symphonia-metadata/0.5.4 \
    crate://crates.io/symphonia-utils-xiph/0.5.4 \
    crate://crates.io/symphonia/0.5.4 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.85 \
    crate://crates.io/sync_wrapper/0.1.2 \
    crate://crates.io/sysinfo/0.31.4 \
    crate://crates.io/system-configuration-sys/0.5.0 \
    crate://crates.io/system-configuration/0.5.1 \
    crate://crates.io/system-deps/7.0.3 \
    crate://crates.io/target-lexicon/0.12.16 \
    crate://crates.io/tempfile/3.13.0 \
    crate://crates.io/thiserror-impl/1.0.65 \
    crate://crates.io/thiserror/1.0.65 \
    crate://crates.io/thread-id/4.2.2 \
    crate://crates.io/time-core/0.1.2 \
    crate://crates.io/time-macros/0.2.18 \
    crate://crates.io/time/0.3.36 \
    crate://crates.io/tinyvec/1.8.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio-macros/2.4.0 \
    crate://crates.io/tokio-rustls/0.24.1 \
    crate://crates.io/tokio-rustls/0.25.0 \
    crate://crates.io/tokio-rustls/0.26.0 \
    crate://crates.io/tokio-stream/0.1.16 \
    crate://crates.io/tokio-tungstenite/0.24.0 \
    crate://crates.io/tokio-util/0.7.12 \
    crate://crates.io/tokio/1.41.0 \
    crate://crates.io/toml/0.8.19 \
    crate://crates.io/toml_datetime/0.6.8 \
    crate://crates.io/toml_edit/0.22.22 \
    crate://crates.io/tower-service/0.3.3 \
    crate://crates.io/tracing-attributes/0.1.27 \
    crate://crates.io/tracing-core/0.1.32 \
    crate://crates.io/tracing/0.1.40 \
    crate://crates.io/try-lock/0.2.5 \
    crate://crates.io/tungstenite/0.24.0 \
    crate://crates.io/typenum/1.17.0 \
    crate://crates.io/uds_windows/1.1.0 \
    crate://crates.io/unicode-bidi/0.3.17 \
    crate://crates.io/unicode-ident/1.0.13 \
    crate://crates.io/unicode-normalization/0.1.24 \
    crate://crates.io/unicode-width/0.1.14 \
    crate://crates.io/untrusted/0.9.0 \
    crate://crates.io/url/2.5.2 \
    crate://crates.io/utf-8/0.7.6 \
    crate://crates.io/utf8parse/0.2.2 \
    crate://crates.io/uuid/1.11.0 \
    crate://crates.io/vergen-gitcl/1.0.1 \
    crate://crates.io/vergen-lib/0.1.4 \
    crate://crates.io/vergen/9.0.1 \
    crate://crates.io/version-compare/0.1.1 \
    crate://crates.io/version-compare/0.2.0 \
    crate://crates.io/version_check/0.9.5 \
    crate://crates.io/walkdir/2.5.0 \
    crate://crates.io/want/0.3.1 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.95 \
    crate://crates.io/wasm-bindgen-futures/0.4.45 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.95 \
    crate://crates.io/wasm-bindgen-macro/0.2.95 \
    crate://crates.io/wasm-bindgen-shared/0.2.95 \
    crate://crates.io/wasm-bindgen/0.2.95 \
    crate://crates.io/web-sys/0.3.72 \
    crate://crates.io/webpki-roots/0.25.4 \
    crate://crates.io/webpki/0.22.4 \
    crate://crates.io/which/4.4.2 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.9 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-core/0.52.0 \
    crate://crates.io/windows-core/0.54.0 \
    crate://crates.io/windows-core/0.57.0 \
    crate://crates.io/windows-implement/0.57.0 \
    crate://crates.io/windows-interface/0.57.0 \
    crate://crates.io/windows-result/0.1.2 \
    crate://crates.io/windows-sys/0.45.0 \
    crate://crates.io/windows-sys/0.48.0 \
    crate://crates.io/windows-sys/0.52.0 \
    crate://crates.io/windows-sys/0.59.0 \
    crate://crates.io/windows-targets/0.42.2 \
    crate://crates.io/windows-targets/0.48.5 \
    crate://crates.io/windows-targets/0.52.6 \
    crate://crates.io/windows/0.52.0 \
    crate://crates.io/windows/0.54.0 \
    crate://crates.io/windows/0.57.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.2 \
    crate://crates.io/windows_aarch64_gnullvm/0.48.5 \
    crate://crates.io/windows_aarch64_gnullvm/0.52.6 \
    crate://crates.io/windows_aarch64_msvc/0.42.2 \
    crate://crates.io/windows_aarch64_msvc/0.48.5 \
    crate://crates.io/windows_aarch64_msvc/0.52.6 \
    crate://crates.io/windows_i686_gnu/0.42.2 \
    crate://crates.io/windows_i686_gnu/0.48.5 \
    crate://crates.io/windows_i686_gnu/0.52.6 \
    crate://crates.io/windows_i686_gnullvm/0.52.6 \
    crate://crates.io/windows_i686_msvc/0.42.2 \
    crate://crates.io/windows_i686_msvc/0.48.5 \
    crate://crates.io/windows_i686_msvc/0.52.6 \
    crate://crates.io/windows_x86_64_gnu/0.42.2 \
    crate://crates.io/windows_x86_64_gnu/0.48.5 \
    crate://crates.io/windows_x86_64_gnu/0.52.6 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.2 \
    crate://crates.io/windows_x86_64_gnullvm/0.48.5 \
    crate://crates.io/windows_x86_64_gnullvm/0.52.6 \
    crate://crates.io/windows_x86_64_msvc/0.42.2 \
    crate://crates.io/windows_x86_64_msvc/0.48.5 \
    crate://crates.io/windows_x86_64_msvc/0.52.6 \
    crate://crates.io/winnow/0.6.20 \
    crate://crates.io/winreg/0.50.0 \
    crate://crates.io/xdg-home/1.3.0 \
    crate://crates.io/zbus/4.4.0 \
    crate://crates.io/zbus_macros/4.4.0 \
    crate://crates.io/zbus_names/3.0.0 \
    crate://crates.io/zerocopy-derive/0.7.35 \
    crate://crates.io/zerocopy/0.7.35 \
    crate://crates.io/zeroize/1.8.1 \
    crate://crates.io/zvariant/4.2.0 \
    crate://crates.io/zvariant_derive/4.2.0 \
    crate://crates.io/zvariant_utils/2.1.0 \
"

SRC_URI[addr2line-0.24.2.sha256sum] = "dfbe277e56a376000877090da837660b4427aad530e3028d44e0bffe4f89a1c1"
SRC_URI[adler2-2.0.0.sha256sum] = "512761e0bb2578dd7380c6baaa0f4ce03e84f95e960231d1dec8bf4d7d6e2627"
SRC_URI[aes-0.8.4.sha256sum] = "b169f7a6d4742236a0a00c541b845991d0ac43e546831af1249753ab4c3aa3a0"
SRC_URI[aho-corasick-1.1.3.sha256sum] = "8e60d3430d3a69478ad0993f19238d2df97c507009a52b3c10addcd7f6bcb916"
SRC_URI[alsa-sys-0.3.1.sha256sum] = "db8fee663d06c4e303404ef5f40488a53e062f89ba8bfed81f42325aafad1527"
SRC_URI[alsa-0.9.1.sha256sum] = "ed7572b7ba83a31e20d1b48970ee402d2e3e0537dcfe0a3ff4d6eb7508617d43"
SRC_URI[android-tzdata-0.1.1.sha256sum] = "e999941b234f3131b00bc13c22d06e8c5ff726d1b6318ac7eb276997bbb4fef0"
SRC_URI[android_system_properties-0.1.5.sha256sum] = "819e7219dbd41043ac279b19830f2efc897156490d7fd6ea916720117ee66311"
SRC_URI[anstream-0.6.17.sha256sum] = "23a1e53f0f5d86382dafe1cf314783b2044280f406e7e1506368220ad11b1338"
SRC_URI[anstyle-parse-0.2.6.sha256sum] = "3b2d16507662817a6a20a9ea92df6652ee4f94f914589377d69f3b21bc5798a9"
SRC_URI[anstyle-query-1.1.2.sha256sum] = "79947af37f4177cfead1110013d678905c37501914fba0efea834c3fe9a8d60c"
SRC_URI[anstyle-wincon-3.0.6.sha256sum] = "2109dbce0e72be3ec00bed26e6a7479ca384ad226efdd66db8fa2e3a38c83125"
SRC_URI[anstyle-1.0.9.sha256sum] = "8365de52b16c035ff4fcafe0092ba9390540e3e352870ac09933bebcaa2c8c56"
SRC_URI[anyhow-1.0.91.sha256sum] = "c042108f3ed77fd83760a5fd79b53be043192bb3b9dba91d8c574c0ada7850c8"
SRC_URI[arrayvec-0.7.6.sha256sum] = "7c02d123df017efcdfbd739ef81735b36c5ba83ec3c59c80a9d7ecc718f92e50"
SRC_URI[async-broadcast-0.7.1.sha256sum] = "20cd0e2e25ea8e5f7e9df04578dc6cf5c83577fd09b1a46aaf5c85e1c33f2a7e"
SRC_URI[async-channel-2.3.1.sha256sum] = "89b47800b0be77592da0afd425cc03468052844aff33b84e33cc696f64e77b6a"
SRC_URI[async-io-2.3.4.sha256sum] = "444b0228950ee6501b3568d3c93bf1176a1fdbc3b758dcd9475046d30f4dc7e8"
SRC_URI[async-lock-3.4.0.sha256sum] = "ff6e472cdea888a4bd64f342f09b3f50e1886d32afe8df3d663c01140b811b18"
SRC_URI[async-process-2.3.0.sha256sum] = "63255f1dc2381611000436537bbedfe83183faa303a5a0edaf191edef06526bb"
SRC_URI[async-recursion-1.1.1.sha256sum] = "3b43422f69d8ff38f95f1b2bb76517c91589a924d1559a0e935d7c8ce0274c11"
SRC_URI[async-signal-0.2.10.sha256sum] = "637e00349800c0bdf8bfc21ebbc0b6524abea702b0da4168ac00d070d0c0b9f3"
SRC_URI[async-task-4.7.1.sha256sum] = "8b75356056920673b02621b35afd0f7dda9306d03c79a30f5c56c44cf256e3de"
SRC_URI[async-trait-0.1.83.sha256sum] = "721cae7de5c34fbb2acd27e21e6d2cf7b886dce0c27388d46c4e6c47ea4318dd"
SRC_URI[atomic-waker-1.1.2.sha256sum] = "1505bd5d3d116872e7271a6d4e16d81d0c8570876c8de68093a09ac269d8aac0"
SRC_URI[atomic_refcell-0.1.13.sha256sum] = "41e67cd8309bbd06cd603a9e693a784ac2e5d1e955f11286e355089fcab3047c"
SRC_URI[autocfg-1.4.0.sha256sum] = "ace50bade8e6234aa140d9a2f552bbee1db4d353f69b8217bc503490fc1a9f26"
SRC_URI[aws-lc-rs-1.10.0.sha256sum] = "cdd82dba44d209fddb11c190e0a94b78651f95299598e472215667417a03ff1d"
SRC_URI[aws-lc-sys-0.22.0.sha256sum] = "df7a4168111d7eb622a31b214057b8509c0a7e1794f44c546d742330dc793972"
SRC_URI[backtrace-0.3.74.sha256sum] = "8d82cb332cdfaed17ae235a638438ac4d4839913cc2af585c3c6746e8f8bee1a"
SRC_URI[base64-0.13.1.sha256sum] = "9e1b586273c5702936fe7b7d6896644d8be71e6314cfe09d3167c95f712589e8"
SRC_URI[base64-0.21.7.sha256sum] = "9d297deb1925b89f2ccc13d7635fa0714f12c87adce1c75356b39ca9b7178567"
SRC_URI[base64-0.22.1.sha256sum] = "72b3254f16251a8381aa12e40e3c4d2f0199f8c6508fbecb9d91f575e0fbb8c6"
SRC_URI[base64ct-1.6.0.sha256sum] = "8c3c1a368f70d6cf7302d78f8f7093da241fb8e8807c05cc9e51a125895a6d5b"
SRC_URI[bindgen-0.69.5.sha256sum] = "271383c67ccabffb7381723dea0672a673f292304fcb45c01cc648c7a8d58088"
SRC_URI[bindgen-0.70.1.sha256sum] = "f49d8fed880d473ea71efb9bf597651e77201bdd4893efe54c9e5d65ae04ce6f"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bitflags-2.6.0.sha256sum] = "b048fb63fd8b5923fc5aa7b340d8e156aec7ec02f0c78fa8a6ddc2613f6f71de"
SRC_URI[block-buffer-0.10.4.sha256sum] = "3078c7629b62d3f0439517fa394996acacc5cbc91c5a20d8c658e77abd503a71"
SRC_URI[blocking-1.6.1.sha256sum] = "703f41c54fc768e63e091340b424302bb1c29ef4aa0c7f10fe849dfb114d29ea"
SRC_URI[bumpalo-3.16.0.sha256sum] = "79296716171880943b8470b5f8d03aa55eb2e645a4874bdbb28adb49162e012c"
SRC_URI[bytemuck-1.19.0.sha256sum] = "8334215b81e418a0a7bdb8ef0849474f40bb10c8b71f1c4ed315cff49f32494d"
SRC_URI[byteorder-1.5.0.sha256sum] = "1fd0f2584146f6f2ef48085050886acf353beff7305ebd1ae69500e27c67f64b"
SRC_URI[bytes-1.8.0.sha256sum] = "9ac0150caa2ae65ca5bd83f25c7de183dea78d4d366469f148435e2acfbad0da"
SRC_URI[cc-1.1.31.sha256sum] = "c2e7962b54006dcfcc61cb72735f4d89bb97061dd6a7ed882ec6b8ee53714c6f"
SRC_URI[cesu8-1.1.0.sha256sum] = "6d43a04d8753f35258c91f8ec639f792891f748a1edbd759cf1dcea3382ad83c"
SRC_URI[cexpr-0.6.0.sha256sum] = "6fac387a98bb7c37292057cffc56d62ecb629900026402633ae9160df93a8766"
SRC_URI[cfg-expr-0.17.0.sha256sum] = "d0890061c4d3223e7267f3bad2ec40b997d64faac1c2815a4a9d95018e2b9e9c"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[cfg_aliases-0.2.1.sha256sum] = "613afe47fcd5fac7ccf1db93babcb082c5994d996f20b8b159f2ad1658eb5724"
SRC_URI[chrono-0.4.38.sha256sum] = "a21f936df1771bf62b77f047b726c4625ff2e8aa607c01ec06e5a05bd8463401"
SRC_URI[cipher-0.4.4.sha256sum] = "773f3b9af64447d2ce9850330c473515014aa235e6a783b02db81ff39e4a3dad"
SRC_URI[clang-sys-1.8.1.sha256sum] = "0b023947811758c97c59bf9d1c188fd619ad4718dcaa767947df1cadb14f39f4"
SRC_URI[cmake-0.1.51.sha256sum] = "fb1e43aa7fd152b1f968787f7dbcdeb306d1867ff373c69955211876c053f91a"
SRC_URI[colorchoice-1.0.3.sha256sum] = "5b63caa9aa9397e2d9480a9b13673856c78d8ac123288526c37d7839f2a86990"
SRC_URI[combine-4.6.7.sha256sum] = "ba5a308b75df32fe02788e748662718f03fde005016435c444eea572398219fd"
SRC_URI[concurrent-queue-2.5.0.sha256sum] = "4ca0197aee26d1ae37445ee532fefce43251d24cc7c166799f4d46817f1d3973"
SRC_URI[const-oid-0.9.6.sha256sum] = "c2459377285ad874054d797f3ccebf984978aa39129f6eafde5cdc8315b612f8"
SRC_URI[core-foundation-sys-0.8.7.sha256sum] = "773648b94d0e5d620f64f280777445740e61fe701025087ec8b57f45c791888b"
SRC_URI[core-foundation-0.9.4.sha256sum] = "91e195e091a93c46f7102ec7818a2aa394e1e1771c3ab4825963fa03e45afb8f"
SRC_URI[coreaudio-rs-0.11.3.sha256sum] = "321077172d79c662f64f5071a03120748d5bb652f5231570141be24cfcd2bace"
SRC_URI[coreaudio-sys-0.2.16.sha256sum] = "2ce857aa0b77d77287acc1ac3e37a05a8c95a2af3647d23b15f263bdaeb7562b"
SRC_URI[cpal-0.15.3.sha256sum] = "873dab07c8f743075e57f524c583985fbaf745602acbe916a01539364369a779"
SRC_URI[cpufeatures-0.2.14.sha256sum] = "608697df725056feaccfa42cffdaeeec3fccc4ffc38358ecd19b243e716a78e0"
SRC_URI[crossbeam-utils-0.8.20.sha256sum] = "22ec99545bb0ed0ea7bb9b8e1e9122ea386ff8a48c0922e43f36d45ab09e0e80"
SRC_URI[crypto-common-0.1.6.sha256sum] = "1bfb12502f3fc46cca1bb51ac28df9d618d813cdc3d2f25b9fe775a34af26bb3"
SRC_URI[ctr-0.9.2.sha256sum] = "0369ee1ad671834580515889b80f2ea915f23b8be8d0daa4bbaf2ac5c7590835"
SRC_URI[darling-0.20.10.sha256sum] = "6f63b86c8a8826a49b8c21f08a2d07338eec8d900540f8630dc76284be802989"
SRC_URI[darling_core-0.20.10.sha256sum] = "95133861a8032aaea082871032f5815eb9e98cef03fa916ab4500513994df9e5"
SRC_URI[darling_macro-0.20.10.sha256sum] = "d336a2a514f6ccccaa3e09b02d41d35330c07ddf03a62165fcec10bb561c7806"
SRC_URI[dasp_sample-0.11.0.sha256sum] = "0c87e182de0887fd5361989c677c4e8f5000cd9491d6d563161a8f3a5519fc7f"
SRC_URI[data-encoding-2.6.0.sha256sum] = "e8566979429cf69b49a5c740c60791108e86440e8be149bbea4fe54d2c32d6e2"
SRC_URI[der-0.7.9.sha256sum] = "f55bf8e7b65898637379c1b74eb1551107c8294ed26d855ceb9fd1a09cfc9bc0"
SRC_URI[deranged-0.3.11.sha256sum] = "b42b6fa04a440b495c8b04d0e71b707c585f83cb9cb28cf8cd0d976c315e31b4"
SRC_URI[derive_builder-0.20.2.sha256sum] = "507dfb09ea8b7fa618fcf76e953f4f5e192547945816d5358edffe39f6f94947"
SRC_URI[derive_builder_core-0.20.2.sha256sum] = "2d5bcf7b024d6835cfb3d473887cd966994907effbe9227e8c8219824d06c4e8"
SRC_URI[derive_builder_macro-0.20.2.sha256sum] = "ab63b0e2bf4d5928aff72e83a7dace85d7bba5fe12dcc3c5a572d78caffd3f3c"
SRC_URI[digest-0.10.7.sha256sum] = "9ed9a281f7bc9b7576e61468ba615a66a5c8cfdff42420a70aa82701a3b1e292"
SRC_URI[dns-sd-0.1.3.sha256sum] = "d748509dea20228f63ba519bf142ce2593396386125b01f5b0d6412dab972087"
SRC_URI[dunce-1.0.5.sha256sum] = "92773504d58c093f6de2459af4af33faa518c13451eb8f2b5698ed3d36e7c813"
SRC_URI[either-1.13.0.sha256sum] = "60b1af1c220855b6ceac025d3f6ecdd2b7c4894bfe9cd9bda4fbb4bc7c0d4cf0"
SRC_URI[encoding_rs-0.8.35.sha256sum] = "75030f3c4f45dafd7586dd6780965a8c7e8e285a5ecb86713e63a79c5b2766f3"
SRC_URI[endi-1.1.0.sha256sum] = "a3d8a32ae18130a3c84dd492d4215c3d913c3b07c6b63c2eb3eb7ff1101ab7bf"
SRC_URI[enumflags2-0.7.10.sha256sum] = "d232db7f5956f3f14313dc2f87985c58bd2c695ce124c8cdd984e08e15ac133d"
SRC_URI[enumflags2_derive-0.7.10.sha256sum] = "de0d48a183585823424a4ce1aa132d174a6a81bd540895822eb4c8373a8e49e8"
SRC_URI[env_filter-0.1.2.sha256sum] = "4f2c92ceda6ceec50f43169f9ee8424fe2db276791afde7b2cd8bc084cb376ab"
SRC_URI[env_logger-0.11.5.sha256sum] = "e13fa619b91fb2381732789fc5de83b45675e882f66623b7d8cb4f643017018d"
SRC_URI[equivalent-1.0.1.sha256sum] = "5443807d6dff69373d433ab9ef5378ad8df50ca6298caf15de6e52e24aaf54d5"
SRC_URI[errno-0.3.9.sha256sum] = "534c5cf6194dfab3db3242765c03bbe257cf92f22b38f6bc0c58d59108a820ba"
SRC_URI[event-listener-strategy-0.5.2.sha256sum] = "0f214dc438f977e6d4e3500aaa277f5ad94ca83fbbd9b1a15713ce2344ccc5a1"
SRC_URI[event-listener-5.3.1.sha256sum] = "6032be9bd27023a771701cc49f9f053c751055f71efb2e0ae5c15809093675ba"
SRC_URI[fastrand-2.1.1.sha256sum] = "e8c02a5121d4ea3eb16a80748c74f5549a5665e4c21333c6098f283870fbdea6"
SRC_URI[fixedbitset-0.4.2.sha256sum] = "0ce7134b9999ecaf8bcd65542e436736ef32ddca1b3e06094cb6ec5755203b80"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[form_urlencoded-1.2.1.sha256sum] = "e13624c2627564efccf4934284bdd98cbaa14e79b0b5a141218e507b3a823456"
SRC_URI[fs_extra-1.3.0.sha256sum] = "42703706b716c37f96a77aea830392ad231f44c9e9a67872fa5548707e11b11c"
SRC_URI[futures-channel-0.3.31.sha256sum] = "2dff15bf788c671c1934e366d07e30c1814a8ef514e1af724a602e8a2fbe1b10"
SRC_URI[futures-core-0.3.31.sha256sum] = "05f29059c0c2090612e8d742178b0580d2dc940c837851ad723096f87af6663e"
SRC_URI[futures-executor-0.3.31.sha256sum] = "1e28d1d997f585e54aebc3f97d39e72338912123a67330d723fdbb564d646c9f"
SRC_URI[futures-io-0.3.31.sha256sum] = "9e5c1b78ca4aae1ac06c48a526a655760685149f0d465d21f37abfe57ce075c6"
SRC_URI[futures-lite-2.4.0.sha256sum] = "3f1fa2f9765705486b33fd2acf1577f8ec449c2ba1f318ae5447697b7c08d210"
SRC_URI[futures-macro-0.3.31.sha256sum] = "162ee34ebcb7c64a8abebc059ce0fee27c2262618d7b60ed8faf72fef13c3650"
SRC_URI[futures-sink-0.3.31.sha256sum] = "e575fab7d1e0dcb8d0c7bcf9a63ee213816ab51902e6d244a95819acacf1d4f7"
SRC_URI[futures-task-0.3.31.sha256sum] = "f90f7dce0722e95104fcb095585910c0977252f286e354b5e3bd38902cd99988"
SRC_URI[futures-timer-3.0.3.sha256sum] = "f288b0a4f20f9a56b5d1da57e2227c661b7b16168e2f72365f57b63326e29b24"
SRC_URI[futures-util-0.3.31.sha256sum] = "9fa08315bb612088cc391249efdc3bc77536f16c91f6cf495e6fbe85b20a4a81"
SRC_URI[futures-0.3.31.sha256sum] = "65bc07b1a8bc7c85c5f2e110c476c7389b4554ba72af57d8445ea63a576b0876"
SRC_URI[generic-array-0.14.7.sha256sum] = "85649ca51fd72272d7821adaf274ad91c288277713d9c18820d8499a7ff69e9a"
SRC_URI[getopts-0.2.21.sha256sum] = "14dbbfd5c71d70241ecf9e6f13737f7b5ce823821063188d7e46c41d371eebd5"
SRC_URI[getrandom-0.2.15.sha256sum] = "c4567c8db10ae91089c99af84c68c38da3ec2f087c3f82960bcdbf3656b6f4d7"
SRC_URI[gimli-0.31.1.sha256sum] = "07e28edb80900c19c28f1072f2e8aeca7fa06b23cd4169cefe1af5aa3260783f"
SRC_URI[gio-sys-0.20.5.sha256sum] = "217f464cad5946ae4369c355155e2d16b488c08920601083cb4891e352ae777b"
SRC_URI[glib-macros-0.20.5.sha256sum] = "e7d21ca27acfc3e91da70456edde144b4ac7c36f78ee77b10189b3eb4901c156"
SRC_URI[glib-sys-0.20.5.sha256sum] = "8a5911863ab7ecd4a6f8d5976f12eeba076b23669c49b066d877e742544aa389"
SRC_URI[glib-0.20.5.sha256sum] = "358431b0e0eb15b9d02db52e1f19c805b953c5c168099deb3de88beab761768c"
SRC_URI[glob-0.3.1.sha256sum] = "d2fabcfbdc87f4758337ca535fb41a6d701b65693ce38287d856d1674551ec9b"
SRC_URI[gobject-sys-0.20.4.sha256sum] = "a4c674d2ff8478cf0ec29d2be730ed779fef54415a2fb4b565c52def62696462"
SRC_URI[governor-0.6.3.sha256sum] = "68a7f542ee6b35af73b06abc0dad1c1bae89964e4e253bc4b587b91c9637867b"
SRC_URI[gstreamer-app-sys-0.23.2.sha256sum] = "08d5cac633c1ab7030c777c8c58c682a0c763bbc4127bccc370dabe39c01a12d"
SRC_URI[gstreamer-app-0.23.2.sha256sum] = "54a4ec9f0d2037349c82f589c1cbfe788a62f4941851924bb7c3929a6a790007"
SRC_URI[gstreamer-audio-sys-0.23.2.sha256sum] = "d84744e7ac8f8bc0cf76b7be40f2d5be12e6cf197e4c6ca9d3438109c21e2f51"
SRC_URI[gstreamer-audio-0.23.2.sha256sum] = "36d39b07213f83055fc705a384fa32ad581776b8e5b04c86f3a419ec5dfc0f81"
SRC_URI[gstreamer-base-sys-0.23.2.sha256sum] = "7796e694c21c215447811c9cff694dce1fc6e02b0bbafb75cd8583b6aefe9e5f"
SRC_URI[gstreamer-base-0.23.2.sha256sum] = "46ce7330d2995138a77192ea20961422ddee1578e1a47480acb820c43ceb0e2d"
SRC_URI[gstreamer-sys-0.23.2.sha256sum] = "cb3859929db32f26a35818d0d9ed82f0887c9221ca402ddefaea2bb99833d535"
SRC_URI[gstreamer-0.23.2.sha256sum] = "49ecf3bcfc2ceb82ce02437f53ff2fcaee5e7d45ae697ab64a018408749779b9"
SRC_URI[h2-0.3.26.sha256sum] = "81fe527a889e1532da5c525686d96d4c2e74cdd345badf8dfef9f6b39dd5f5e8"
SRC_URI[h2-0.4.6.sha256sum] = "524e8ac6999421f49a846c2d4411f337e53497d8ec55d67753beffa43c5d9205"
SRC_URI[hashbrown-0.15.0.sha256sum] = "1e087f84d4f86bf4b218b927129862374b72199ae7d8657835f1e89000eea4fb"
SRC_URI[headers-core-0.3.0.sha256sum] = "54b4a22553d4242c49fddb9ba998a99962b5cc6f22cb5a3482bec22522403ce4"
SRC_URI[headers-0.4.0.sha256sum] = "322106e6bd0cba2d5ead589ddb8150a13d7c4217cf80d7c4f682ca994ccc6aa9"
SRC_URI[heck-0.5.0.sha256sum] = "2304e00983f87ffb38b55b444b5e3b60a884b5d30c0fca7d82fe33449bbe55ea"
SRC_URI[hermit-abi-0.3.9.sha256sum] = "d231dfb89cfffdbc30e7fc41579ed6066ad03abda9e567ccafae602b97ec5024"
SRC_URI[hermit-abi-0.4.0.sha256sum] = "fbf6a919d6cf397374f7dfeeea91d974c7c0a7221d0d0f4f20d859d329e53fcc"
SRC_URI[hex-0.4.3.sha256sum] = "7f24254aa9a54b5c858eaee2f5bccdb46aaf0e486a595ed5fd8f86ba55232a70"
SRC_URI[hmac-0.12.1.sha256sum] = "6c49c37c09c17a53d937dfbb742eb3a961d65a994e6bcdcf37e7399d0cc8ab5e"
SRC_URI[home-0.5.9.sha256sum] = "e3d1354bf6b7235cb4a0576c2619fd4ed18183f689b12b006a0ee7329eeff9a5"
SRC_URI[hostname-0.4.0.sha256sum] = "f9c7c7c8ac16c798734b8a24560c1362120597c40d5e1459f09498f8f6c8f2ba"
SRC_URI[http-body-util-0.1.2.sha256sum] = "793429d76616a256bcb62c2a2ec2bed781c8307e797e2598c50010f2bee2544f"
SRC_URI[http-body-0.4.6.sha256sum] = "7ceab25649e9960c0311ea418d17bee82c0dcec1bd053b5f9a66e265a693bed2"
SRC_URI[http-body-1.0.1.sha256sum] = "1efedce1fb8e6913f23e0c92de8e62cd5b772a67e7b3946df930a62566c93184"
SRC_URI[http-0.2.12.sha256sum] = "601cbb57e577e2f5ef5be8e7b83f0f63994f25aa94d673e54a92d5c516d101f1"
SRC_URI[http-1.1.0.sha256sum] = "21b9ddb458710bc376481b842f5da65cdf31522de232c1ca8146abce2a358258"
SRC_URI[httparse-1.9.5.sha256sum] = "7d71d3574edd2771538b901e6549113b4006ece66150fb69c0fb6d9a2adae946"
SRC_URI[httpdate-1.0.3.sha256sum] = "df3b46402a9d5adb4c86a0cf463f42e19994e3ee891101b1841f30a545cb49a9"
SRC_URI[humantime-2.1.0.sha256sum] = "9a3a5bfb195931eeb336b2a7b4d761daec841b97f947d34394601737a7bba5e4"
SRC_URI[hyper-proxy2-0.1.0.sha256sum] = "9043b7b23fb0bc4a1c7014c27b50a4fc42cc76206f71d34fc0dfe5b28ddc3faf"
SRC_URI[hyper-rustls-0.24.2.sha256sum] = "ec3efd23720e2049821a693cbc7e65ea87c72f1c58ff2f9522ff332b1491e590"
SRC_URI[hyper-rustls-0.26.0.sha256sum] = "a0bea761b46ae2b24eb4aef630d8d1c398157b6fc29e6350ecf090a0b70c952c"
SRC_URI[hyper-rustls-0.27.3.sha256sum] = "08afdbb5c31130e3034af566421053ab03787c640246a446327f550d11bcb333"
SRC_URI[hyper-util-0.1.10.sha256sum] = "df2dcfbe0677734ab2f3ffa7fa7bfd4706bfdc1ef393f2ee30184aed67e631b4"
SRC_URI[hyper-0.14.31.sha256sum] = "8c08302e8fa335b151b788c775ff56e7a03ae64ff85c548ee820fecb70356e85"
SRC_URI[hyper-1.5.0.sha256sum] = "bbbff0a806a4728c99295b254c8838933b5b082d75e3cb70c8dab21fdfbcfa9a"
SRC_URI[iana-time-zone-haiku-0.1.2.sha256sum] = "f31827a206f56af32e590ba56d5d2d085f558508192593743f16b2306495269f"
SRC_URI[iana-time-zone-0.1.61.sha256sum] = "235e081f3925a06703c2d0117ea8b91f042756fd6e7a6e5d901e8ca1a996b220"
SRC_URI[ident_case-1.0.1.sha256sum] = "b9e0384b61958566e926dc50660321d12159025e767c18e043daf26b70104c39"
SRC_URI[idna-0.5.0.sha256sum] = "634d9b1461af396cad843f47fdba5597a4f9e6ddd4bfb6ff5d85028c25cb12f6"
SRC_URI[if-addrs-0.12.0.sha256sum] = "bb2a33e9c38988ecbda730c85b0fd9ddcdf83c0305ac7fd21c8bb9f57f2f0cc8"
SRC_URI[indexmap-2.6.0.sha256sum] = "707907fe3c25f5424cce2cb7e1cbcafee6bdbe735ca90ef77c29e84591e5b9da"
SRC_URI[inout-0.1.3.sha256sum] = "a0c10553d664a4d0bcff9f4215d0aac67a639cc68ef660840afe309b807bc9f5"
SRC_URI[ipnet-2.10.1.sha256sum] = "ddc24109865250148c2e0f3d25d4f0f479571723792d3802153c60922a4fb708"
SRC_URI[is_terminal_polyfill-1.70.1.sha256sum] = "7943c866cc5cd64cbc25b2e01621d07fa8eb2a1a23160ee81ce38704e97b8ecf"
SRC_URI[itertools-0.12.1.sha256sum] = "ba291022dbbd398a455acf126c1e341954079855bc60dfdda641363bd6922569"
SRC_URI[itertools-0.13.0.sha256sum] = "413ee7dfc52ee1a4949ceeb7dbc8a33f2d6c088194d9f922fb8318faf1f01186"
SRC_URI[itoa-1.0.11.sha256sum] = "49f1f14873335454500d59611f1cf4a4b0f786f9ac11f4312a78e4cf2566695b"
SRC_URI[jack-sys-0.5.1.sha256sum] = "6013b7619b95a22b576dfb43296faa4ecbe40abbdb97dfd22ead520775fc86ab"
SRC_URI[jack-0.11.4.sha256sum] = "0e5a18a3c2aefb354fb77111ade228b20267bdc779de84e7a4ccf7ea96b9a6cd"
SRC_URI[jni-sys-0.3.0.sha256sum] = "8eaf4bc02d17cbdd7ff4c7438cafcdf7fb9a4613313ad11b4f8fefe7d3fa0130"
SRC_URI[jni-0.21.1.sha256sum] = "1a87aa2bb7d2af34197c04845522473242e1aa17c12f4935d5856491a7fb8c97"
SRC_URI[jobserver-0.1.32.sha256sum] = "48d1dbcbbeb6a7fec7e059840aa538bd62aaccf972c7346c4d9d2059312853d0"
SRC_URI[js-sys-0.3.72.sha256sum] = "6a88f1bda2bd75b0452a14784937d796722fdebfe50df998aeb3f0b7603019a9"
SRC_URI[lazy_static-1.5.0.sha256sum] = "bbd2bcb4c963f2ddae06a2efc7e9f3591312473c50c6685e1f298068316e66fe"
SRC_URI[lazycell-1.3.0.sha256sum] = "830d08ce1d1d941e6b30645f1a0eb5643013d835ce3779a5fc208261dbe10f55"
SRC_URI[libc-0.2.161.sha256sum] = "8e9489c2807c139ffd9c1794f4af0ebe86a828db53ecdc7fea2111d0fed085d1"
SRC_URI[libloading-0.7.4.sha256sum] = "b67380fd3b2fbe7527a606e18729d21c6f3951633d0500574c4dc22d2d638b9f"
SRC_URI[libloading-0.8.5.sha256sum] = "4979f22fdb869068da03c9f7528f8297c6fd2606bc3a4affe42e6a823fdb8da4"
SRC_URI[libm-0.2.11.sha256sum] = "8355be11b20d696c8f18f6cc018c4e372165b1fa8126cef092399c9951984ffa"
SRC_URI[libmdns-0.9.1.sha256sum] = "48854699e11b111433431b69cee2365fcab0b29b06993f48c257dfbaf6395862"
SRC_URI[libpulse-binding-2.28.1.sha256sum] = "ed3557a2dfc380c8f061189a01c6ae7348354e0c9886038dc6c171219c08eaff"
SRC_URI[libpulse-simple-binding-2.28.1.sha256sum] = "05fd6b68f33f6a251265e6ed1212dc3107caad7c5c6fdcd847b2e65ef58c308d"
SRC_URI[libpulse-simple-sys-1.21.1.sha256sum] = "ea6613b4199d8b9f0edcfb623e020cb17bbd0bee8dd21f3c7cc938de561c4152"
SRC_URI[libpulse-sys-1.21.0.sha256sum] = "bc19e110fbf42c17260d30f6d3dc545f58491c7830d38ecb9aaca96e26067a9b"
SRC_URI[linux-raw-sys-0.4.14.sha256sum] = "78b3ae25bc7c8c38cec158d1f2757ee79e9b3740fbc7ccf0e59e4b08d793fa89"
SRC_URI[lock_api-0.4.12.sha256sum] = "07af8b9cdd281b7915f413fa73f29ebd5d55d0d3f0155584dade1ff18cea1b17"
SRC_URI[log-0.4.22.sha256sum] = "a7a70ba024b9dc04c27ea2f0c0548feb474ec5c54bba33a7f72f873a39d07b24"
SRC_URI[mach2-0.4.2.sha256sum] = "19b955cdeb2a02b9117f121ce63aa52d08ade45de53e48fe6a38b39c10f6f709"
SRC_URI[memchr-2.7.4.sha256sum] = "78ca9ab1a0babb1e7d5695e3530886289c18cf2f87ec19a575a0abdce112e3a3"
SRC_URI[memoffset-0.9.1.sha256sum] = "488016bfae457b036d996092f6cb448677611ce4449e970ceaf42695203f218a"
SRC_URI[mime-0.3.17.sha256sum] = "6877bb514081ee2a7ff5ef9de3281f14a4dd4bceac4c09388074a6b5df8a139a"
SRC_URI[minimal-lexical-0.2.1.sha256sum] = "68354c5c6bd36d73ff3feceb05efa59b6acb7626617f4962be322a825e61f79a"
SRC_URI[miniz_oxide-0.8.0.sha256sum] = "e2d80299ef12ff69b16a84bb182e3b9df68b5a91574d3d4fa6e41b65deec4df1"
SRC_URI[mio-1.0.2.sha256sum] = "80e04d1dcff3aae0704555fe5fee3bcfaf3d1fdf8a7e521d5b9d2b42acb52cec"
SRC_URI[mirai-annotations-1.12.0.sha256sum] = "c9be0862c1b3f26a88803c4a49de6889c10e608b3ee9344e6ef5b45fb37ad3d1"
SRC_URI[muldiv-1.0.1.sha256sum] = "956787520e75e9bd233246045d19f42fb73242759cc57fba9611d940ae96d4b0"
SRC_URI[multimap-0.10.0.sha256sum] = "defc4c55412d89136f966bbb339008b474350e5e6e78d2714439c386b3137a03"
SRC_URI[ndk-context-0.1.1.sha256sum] = "27b02d87554356db9e9a873add8782d4ea6e3e58ea071a9adb9a2e8ddb884a8b"
SRC_URI[ndk-sys-0.5.0+25.2.9519653.sha256sum] = "8c196769dd60fd4f363e11d948139556a344e79d451aeb2fa2fd040738ef7691"
SRC_URI[ndk-0.8.0.sha256sum] = "2076a31b7010b17a38c01907c45b945e8f11495ee4dd588309718901b1f7a5b7"
SRC_URI[nix-0.29.0.sha256sum] = "71e2746dc3a24dd78b3cfcb7be93368c6de9963d30f43a6a73998a9cf4b17b46"
SRC_URI[no-std-compat-0.4.1.sha256sum] = "b93853da6d84c2e3c7d730d6473e8817692dd89be387eb01b94d7f108ecb5b8c"
SRC_URI[nom-7.1.3.sha256sum] = "d273983c5a657a70a3e8f2a01329822f3b8c8172b73826411a55751e404a0a4a"
SRC_URI[nonzero_ext-0.3.0.sha256sum] = "38bf9645c8b145698bb0b18a4637dcacbc421ea49bef2317e4fd8065a387cf21"
SRC_URI[ntapi-0.4.1.sha256sum] = "e8a3895c6391c39d7fe7ebc444a87eb2991b2a0bc718fdabd071eec617fc68e4"
SRC_URI[num-bigint-dig-0.8.4.sha256sum] = "dc84195820f291c7697304f3cbdadd1cb7199c0efc917ff5eafd71225c136151"
SRC_URI[num-bigint-0.4.6.sha256sum] = "a5e44f723f1133c9deac646763579fdb3ac745e418f2a7af9cd0c431da1f20b9"
SRC_URI[num-conv-0.1.0.sha256sum] = "51d515d32fb182ee37cda2ccdcb92950d6a3c2893aa280e540671c2cd0f3b1d9"
SRC_URI[num-derive-0.3.3.sha256sum] = "876a53fff98e03a936a674b29568b0e605f06b29372c2489ff4de23f1949743d"
SRC_URI[num-derive-0.4.2.sha256sum] = "ed3955f1a9c7c0c15e092f9c887db08b1fc683305fdf6eb6684f22555355e202"
SRC_URI[num-integer-0.1.46.sha256sum] = "7969661fd2958a5cb096e56c8e1ad0444ac2bbcd0061bd28660485a44879858f"
SRC_URI[num-iter-0.1.45.sha256sum] = "1429034a0490724d0075ebb2bc9e875d6503c3cf69e235a8941aa757d83ef5bf"
SRC_URI[num-rational-0.4.2.sha256sum] = "f83d14da390562dca69fc84082e73e548e1ad308d24accdedd2720017cb37824"
SRC_URI[num-traits-0.2.19.sha256sum] = "071dfc062690e90b734c0b2273ce72ad0ffa95f0c74596bc250dcfd960262841"
SRC_URI[num_enum-0.7.3.sha256sum] = "4e613fc340b2220f734a8595782c551f1250e969d87d3be1ae0579e8d4065179"
SRC_URI[num_enum_derive-0.7.3.sha256sum] = "af1844ef2428cc3e1cb900be36181049ef3d3193c63e43026cfe202983b27a56"
SRC_URI[num_threads-0.1.7.sha256sum] = "5c7398b9c8b70908f6371f47ed36737907c87c52af34c268fed0bf0ceb92ead9"
SRC_URI[oauth2-4.4.2.sha256sum] = "c38841cdd844847e3e7c8d29cef9dcfed8877f8f56f9071f77843ecf3baf937f"
SRC_URI[object-0.36.5.sha256sum] = "aedf0a2d09c573ed1d8d85b30c119153926a2b36dce0ab28322c09a117a4683e"
SRC_URI[oboe-sys-0.6.1.sha256sum] = "6c8bb09a4a2b1d668170cfe0a7d5bc103f8999fb316c98099b6a9939c9f2e79d"
SRC_URI[oboe-0.6.1.sha256sum] = "e8b61bebd49e5d43f5f8cc7ee2891c16e0f41ec7954d36bcb6c14c5e0de867fb"
SRC_URI[ogg-0.9.1.sha256sum] = "5477016638150530ba21dec7caac835b29ef69b20865751d2973fce6be386cf1"
SRC_URI[once_cell-1.20.2.sha256sum] = "1261fe7e33c73b354eab43b1273a57c8f967d0391e80353e51f764ac02cf6775"
SRC_URI[openssl-probe-0.1.5.sha256sum] = "ff011a302c396a5197692431fc1948019154afc178baf7d8e37367442a4601cf"
SRC_URI[option-operations-0.5.0.sha256sum] = "7c26d27bb1aeab65138e4bf7666045169d1717febcc9ff870166be8348b223d0"
SRC_URI[ordered-stream-0.2.0.sha256sum] = "9aa2b01e1d916879f73a53d01d1d6cee68adbb31d6d9177a8cfce093cced1d50"
SRC_URI[parking-2.2.1.sha256sum] = "f38d5652c16fde515bb1ecef450ab0f6a219d619a7274976324d5e377f7dceba"
SRC_URI[parking_lot-0.12.3.sha256sum] = "f1bf18183cf54e8d6059647fc3063646a1801cf30896933ec2311622cc4b9a27"
SRC_URI[parking_lot_core-0.9.10.sha256sum] = "1e401f977ab385c9e4e3ab30627d6f26d00e2c73eef317493c4ec6d468726cf8"
SRC_URI[paste-1.0.15.sha256sum] = "57c0d7b74b563b49d38dae00a0c37d4d6de9b432382b2892f0574ddcae73fd0a"
SRC_URI[pbkdf2-0.12.2.sha256sum] = "f8ed6a7761f76e3b9f92dfb0a60a6a6477c61024b775147ff0973a02653abaf2"
SRC_URI[pem-rfc7468-0.7.0.sha256sum] = "88b39c9bfcfc231068454382784bb460aae594343fb030d46e9f50a645418412"
SRC_URI[percent-encoding-2.3.1.sha256sum] = "e3148f5046208a5d56bcfc03053e3ca6334e51da8dfb19b6cdc8b306fae3283e"
SRC_URI[petgraph-0.6.5.sha256sum] = "b4c5cc86750666a3ed20bdaf5ca2a0344f9c67674cae0515bec2da16fbaa47db"
SRC_URI[pin-project-lite-0.2.15.sha256sum] = "915a1e146535de9163f3987b8944ed8cf49a18bb0056bcebcdcece385cece4ff"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[piper-0.2.4.sha256sum] = "96c8c490f422ef9a4efd2cb5b42b76c8613d7e7dfc1caf667b8a3350a5acc066"
SRC_URI[pkcs1-0.7.5.sha256sum] = "c8ffb9f10fa047879315e6625af03c164b16962a5368d724ed16323b68ace47f"
SRC_URI[pkcs8-0.10.2.sha256sum] = "f950b2377845cebe5cf8b5165cb3cc1a5e0fa5cfa3e1f7f55707d8fd82e0a7b7"
SRC_URI[pkg-config-0.3.31.sha256sum] = "953ec861398dccce10c670dfeaf3ec4911ca479e9c02154b3a215178c5f566f2"
SRC_URI[polling-3.7.3.sha256sum] = "cc2790cd301dec6cd3b7a025e4815cf825724a51c98dccfe6a3e55f05ffb6511"
SRC_URI[portable-atomic-1.9.0.sha256sum] = "cc9c68a3f6da06753e9335d63e27f6b9754dd1920d941135b7ea8224f141adb2"
SRC_URI[portaudio-rs-0.3.2.sha256sum] = "cdb6b5eff96ccc9bf44d34c379ab03ae944426d83d1694345bdf8159d561d562"
SRC_URI[portaudio-sys-0.1.1.sha256sum] = "5194a4fa953b4ffd851c320ef6f0484cd7278cb7169ea9d6c433e49b23f7b7f5"
SRC_URI[powerfmt-0.2.0.sha256sum] = "439ee305def115ba05938db6eb1644ff94165c5ab5e9420d1c1bcedbba909391"
SRC_URI[ppv-lite86-0.2.20.sha256sum] = "77957b295656769bb8ad2b6a6b09d897d94f05c41b069aede1fcdaa675eaea04"
SRC_URI[prettyplease-0.2.25.sha256sum] = "64d1ec885c64d0457d564db4ec299b2dae3f9c02808b8ad9c3a089c591b18033"
SRC_URI[priority-queue-2.1.1.sha256sum] = "714c75db297bc88a63783ffc6ab9f830698a6705aa0201416931759ef4c8183d"
SRC_URI[proc-macro-crate-3.2.0.sha256sum] = "8ecf48c7ca261d60b74ab1a7b20da18bede46776b2e55535cb958eb595c5fa7b"
SRC_URI[proc-macro2-1.0.89.sha256sum] = "f139b0662de085916d1fb67d2b4169d1addddda1919e696f3252b740b629986e"
SRC_URI[protobuf-codegen-3.7.1.sha256sum] = "e26b833f144769a30e04b1db0146b2aaa53fd2fd83acf10a6b5f996606c18144"
SRC_URI[protobuf-parse-3.7.1.sha256sum] = "322330e133eab455718444b4e033ebfac7c6528972c784fcde28d2cc783c6257"
SRC_URI[protobuf-support-3.7.1.sha256sum] = "b088fd20b938a875ea00843b6faf48579462630015c3788d397ad6a786663252"
SRC_URI[protobuf-3.7.1.sha256sum] = "a3a7c64d9bf75b1b8d981124c14c179074e8caa7dfe7b6a12e6222ddcd0c8f72"
SRC_URI[quick-xml-0.36.2.sha256sum] = "f7649a7b4df05aed9ea7ec6f628c67c9953a43869b8bc50929569b2999d443fe"
SRC_URI[quote-1.0.37.sha256sum] = "b5b9d34b8991d19d98081b46eacdd8eb58c6f2b201139f7c5f643cc155a633af"
SRC_URI[rand-0.8.5.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand_chacha-0.3.1.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_core-0.6.4.sha256sum] = "ec0be4795e2f6a28069bec0b5ff3e2ac9bafc99e6a9a7dc3547996c5c816922c"
SRC_URI[rand_distr-0.4.3.sha256sum] = "32cb0b9bc82b0a0876c2dd994a7e7a2683d3e7390ca40e6886785ef0c7e3ee31"
SRC_URI[redox_syscall-0.5.7.sha256sum] = "9b6dfecf2c74bce2466cabf93f6664d6998a69eb21e39f4207930065b27b771f"
SRC_URI[regex-automata-0.4.8.sha256sum] = "368758f23274712b504848e9d5a6f010445cc8b87a7cdb4d7cbee666c1288da3"
SRC_URI[regex-syntax-0.8.5.sha256sum] = "2b15c43186be67a4fd63bee50d0303afffcef381492ebe2c5d87f324e1b8815c"
SRC_URI[regex-1.11.1.sha256sum] = "b544ef1b4eac5dc2db33ea63606ae9ffcfac26c1416a2806ae0bf5f56b201191"
SRC_URI[reqwest-0.11.27.sha256sum] = "dd67538700a17451e7cba03ac727fb961abb7607553461627b97de0b89cf4a62"
SRC_URI[ring-0.17.8.sha256sum] = "c17fa4cb658e3583423e915b9f3acc01cceaee1860e33d59ebae66adc3a2dc0d"
SRC_URI[rodio-0.19.0.sha256sum] = "6006a627c1a38d37f3d3a85c6575418cfe34a5392d60a686d0071e1c8d427acb"
SRC_URI[rsa-0.9.6.sha256sum] = "5d0e5124fcb30e76a7e79bfee683a2746db83784b86289f6251b54b7950a0dfc"
SRC_URI[rustc-demangle-0.1.24.sha256sum] = "719b953e2095829ee67db738b3bfa9fa368c94900df327b3f07fe6e794d2fe1f"
SRC_URI[rustc-hash-1.1.0.sha256sum] = "08d43f7aa6b08d49f382cde6a7982047c3426db949b1424bc4b7ec9ae12c6ce2"
SRC_URI[rustix-0.38.38.sha256sum] = "aa260229e6538e52293eeb577aabd09945a09d6d9cc0fc550ed7529056c2e32a"
SRC_URI[rustls-native-certs-0.7.3.sha256sum] = "e5bfb394eeed242e909609f56089eecfe5fda225042e8b171791b9c95f5931e5"
SRC_URI[rustls-native-certs-0.8.0.sha256sum] = "fcaf18a4f2be7326cd874a5fa579fae794320a0f388d365dca7e480e55f83f8a"
SRC_URI[rustls-pemfile-1.0.4.sha256sum] = "1c74cae0a4cf6ccbbf5f359f08efdf8ee7e1dc532573bf0db71968cb56b1448c"
SRC_URI[rustls-pemfile-2.2.0.sha256sum] = "dce314e5fee3f39953d46bb63bb8a46d40c2f8fb7cc5a3b6cab2bde9721d6e50"
SRC_URI[rustls-pki-types-1.10.0.sha256sum] = "16f1201b3c9a7ee8039bcadc17b7e605e2945b27eee7631788c1bd2b0643674b"
SRC_URI[rustls-webpki-0.101.7.sha256sum] = "8b6275d1ee7a1cd780b64aca7726599a1dbc893b1e64144529e55c3c2f745765"
SRC_URI[rustls-webpki-0.102.8.sha256sum] = "64ca1bc8749bd4cf37b5ce386cc146580777b4e8572c7b97baf22c83f444bee9"
SRC_URI[rustls-0.21.12.sha256sum] = "3f56a14d1f48b391359b22f731fd4bd7e43c97f3c50eee276f3aa09c94784d3e"
SRC_URI[rustls-0.22.4.sha256sum] = "bf4ef73721ac7bcd79b2b315da7779d8fc09718c6b3d2d1b2d94850eb8c18432"
SRC_URI[rustls-0.23.16.sha256sum] = "eee87ff5d9b36712a58574e12e9f0ea80f915a5b0ac518d322b24a465617925e"
SRC_URI[rustversion-1.0.18.sha256sum] = "0e819f2bc632f285be6d7cd36e25940d45b2391dd6d9b939e79de557f7014248"
SRC_URI[ryu-1.0.18.sha256sum] = "f3cb5ba0dc43242ce17de99c180e96db90b235b8a9fdc9543c96d2209116bd9f"
SRC_URI[same-file-1.0.6.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[schannel-0.1.26.sha256sum] = "01227be5826fa0690321a2ba6c5cd57a19cf3f6a09e76973b58e61de6ab9d1c1"
SRC_URI[scopeguard-1.2.0.sha256sum] = "94143f37725109f92c262ed2cf5e59bce7498c01bcc1502d7b9afe439a4e9f49"
SRC_URI[sct-0.7.1.sha256sum] = "da046153aa2352493d6cb7da4b6e5c0c057d8a1d0a9aa8560baffdd945acd414"
SRC_URI[sdl2-sys-0.37.0.sha256sum] = "951deab27af08ed9c6068b7b0d05a93c91f0a8eb16b6b816a5e73452a43521d3"
SRC_URI[sdl2-0.37.0.sha256sum] = "3b498da7d14d1ad6c839729bd4ad6fc11d90a57583605f3b4df2cd709a9cd380"
SRC_URI[security-framework-sys-2.12.0.sha256sum] = "ea4a292869320c0272d7bc55a5a6aafaff59b4f63404a003887b679a2e05b4b6"
SRC_URI[security-framework-2.11.1.sha256sum] = "897b2245f0b511c87893af39b033e5ca9cce68824c4d7e7630b5a1d339658d02"
SRC_URI[serde-1.0.214.sha256sum] = "f55c3193aca71c12ad7890f1785d2b73e1b9f63a0bbc353c08ef26fe03fc56b5"
SRC_URI[serde_derive-1.0.214.sha256sum] = "de523f781f095e28fa605cdce0f8307e451cc0fd14e2eb4cd2e98a355b147766"
SRC_URI[serde_json-1.0.132.sha256sum] = "d726bfaff4b320266d395898905d0eba0345aae23b54aee3a737e260fd46db03"
SRC_URI[serde_path_to_error-0.1.16.sha256sum] = "af99884400da37c88f5e9146b7f1fd0fbcae8f6eec4e9da38b67d05486f814a6"
SRC_URI[serde_repr-0.1.19.sha256sum] = "6c64451ba24fc7a6a2d60fc75dd9c83c90903b19028d4eff35e88fc1e86564e9"
SRC_URI[serde_spanned-0.6.8.sha256sum] = "87607cb1398ed59d48732e575a4c28a7a8ebf2454b964fe3f224f2afc07909e1"
SRC_URI[serde_urlencoded-0.7.1.sha256sum] = "d3491c14715ca2294c4d6a88f15e84739788c1d030eed8c110436aafdaa2f3fd"
SRC_URI[sha1-0.10.6.sha256sum] = "e3bf829a2d51ab4a5ddf1352d8470c140cadc8301b2ae1789db023f01cedd6ba"
SRC_URI[sha2-0.10.8.sha256sum] = "793db75ad2bcafc3ffa7c68b215fee268f537982cd901d132f89c6343f3a3dc8"
SRC_URI[shannon-0.2.0.sha256sum] = "7ea5b41c9427b56caa7b808cb548a04fb50bb5b9e98590b53f28064ff4174561"
SRC_URI[shell-words-1.1.0.sha256sum] = "24188a676b6ae68c3b2cb3a01be17fbf7240ce009799bb56d5b1409051e78fde"
SRC_URI[shlex-1.3.0.sha256sum] = "0fda2ff0d084019ba4d7c6f371c95d8fd75ce3524c3cb8fb653a3023f6323e64"
SRC_URI[signal-hook-registry-1.4.2.sha256sum] = "a9e9e0b4211b72e7b8b6e85c807d36c212bdb33ea8587f7569562a84df5465b1"
SRC_URI[signature-2.2.0.sha256sum] = "77549399552de45a898a580c1b41d445bf730df867cc44e6c0233bbc4b8329de"
SRC_URI[slab-0.4.9.sha256sum] = "8f92a496fb766b417c996b9c5e57daf2f7ad3b0bebe1ccfca4856390e3d3bb67"
SRC_URI[smallvec-1.13.2.sha256sum] = "3c5e1a9a646d36c3599cd173a41282daf47c44583ad367b8e6837255952e5c67"
SRC_URI[socket2-0.5.7.sha256sum] = "ce305eb0b4296696835b71df73eb912e0f1ffd2556a501fcede6e0c50349191c"
SRC_URI[spin-0.9.8.sha256sum] = "6980e8d7511241f8acf4aebddbb1ff938df5eebe98691418c4468d0b72a96a67"
SRC_URI[spinning_top-0.3.0.sha256sum] = "d96d2d1d716fb500937168cc09353ffdc7a012be8475ac7308e1bdf0e3923300"
SRC_URI[spki-0.7.3.sha256sum] = "d91ed6c858b01f942cd56b37a94b3e0a1798290327d1236e4d9cf4eaca44d29d"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[strsim-0.11.1.sha256sum] = "7da8b5736845d9f2fcb837ea5d9e2628564b3b043a70948a3f0b778838c5fb4f"
SRC_URI[subtle-2.6.1.sha256sum] = "13c2bddecc57b384dee18652358fb23172facb8a2c51ccc10d74c157bdea3292"
SRC_URI[symphonia-bundle-mp3-0.5.4.sha256sum] = "c01c2aae70f0f1fb096b6f0ff112a930b1fb3626178fba3ae68b09dce71706d4"
SRC_URI[symphonia-codec-vorbis-0.5.4.sha256sum] = "5a98765fb46a0a6732b007f7e2870c2129b6f78d87db7987e6533c8f164a9f30"
SRC_URI[symphonia-core-0.5.4.sha256sum] = "798306779e3dc7d5231bd5691f5a813496dc79d3f56bf82e25789f2094e022c3"
SRC_URI[symphonia-format-ogg-0.5.4.sha256sum] = "ada3505789516bcf00fc1157c67729eded428b455c27ca370e41f4d785bfa931"
SRC_URI[symphonia-metadata-0.5.4.sha256sum] = "bc622b9841a10089c5b18e99eb904f4341615d5aa55bbf4eedde1be721a4023c"
SRC_URI[symphonia-utils-xiph-0.5.4.sha256sum] = "484472580fa49991afda5f6550ece662237b00c6f562c7d9638d1b086ed010fe"
SRC_URI[symphonia-0.5.4.sha256sum] = "815c942ae7ee74737bb00f965fa5b5a2ac2ce7b6c01c0cc169bbeaf7abd5f5a9"
SRC_URI[syn-1.0.109.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[syn-2.0.85.sha256sum] = "5023162dfcd14ef8f32034d8bcd4cc5ddc61ef7a247c024a33e24e1f24d21b56"
SRC_URI[sync_wrapper-0.1.2.sha256sum] = "2047c6ded9c721764247e62cd3b03c09ffc529b2ba5b10ec482ae507a4a70160"
SRC_URI[sysinfo-0.31.4.sha256sum] = "355dbe4f8799b304b05e1b0f05fc59b2a18d36645cf169607da45bde2f69a1be"
SRC_URI[system-configuration-sys-0.5.0.sha256sum] = "a75fb188eb626b924683e3b95e3a48e63551fcfb51949de2f06a9d91dbee93c9"
SRC_URI[system-configuration-0.5.1.sha256sum] = "ba3a3adc5c275d719af8cb4272ea1c4a6d668a777f37e115f6d11ddbc1c8e0e7"
SRC_URI[system-deps-7.0.3.sha256sum] = "66d23aaf9f331227789a99e8de4c91bf46703add012bdfd45fdecdfb2975a005"
SRC_URI[target-lexicon-0.12.16.sha256sum] = "61c41af27dd6d1e27b1b16b489db798443478cef1f06a660c96db617ba5de3b1"
SRC_URI[tempfile-3.13.0.sha256sum] = "f0f2c9fc62d0beef6951ccffd757e241266a2c833136efbe35af6cd2567dca5b"
SRC_URI[thiserror-impl-1.0.65.sha256sum] = "ae71770322cbd277e69d762a16c444af02aa0575ac0d174f0b9562d3b37f8602"
SRC_URI[thiserror-1.0.65.sha256sum] = "5d11abd9594d9b38965ef50805c5e469ca9cc6f197f883f717e0269a3057b3d5"
SRC_URI[thread-id-4.2.2.sha256sum] = "cfe8f25bbdd100db7e1d34acf7fd2dc59c4bf8f7483f505eaa7d4f12f76cc0ea"
SRC_URI[time-core-0.1.2.sha256sum] = "ef927ca75afb808a4d64dd374f00a2adf8d0fcff8e7b184af886c3c87ec4a3f3"
SRC_URI[time-macros-0.2.18.sha256sum] = "3f252a68540fde3a3877aeea552b832b40ab9a69e318efd078774a01ddee1ccf"
SRC_URI[time-0.3.36.sha256sum] = "5dfd88e563464686c916c7e46e623e520ddc6d79fa6641390f2e3fa86e83e885"
SRC_URI[tinyvec-1.8.0.sha256sum] = "445e881f4f6d382d5f27c034e25eb92edd7c784ceab92a0937db7f2e9471b938"
SRC_URI[tinyvec_macros-0.1.1.sha256sum] = "1f3ccbac311fea05f86f61904b462b55fb3df8837a366dfc601a0161d0532f20"
SRC_URI[tokio-macros-2.4.0.sha256sum] = "693d596312e88961bc67d7f1f97af8a70227d9f90c31bba5806eec004978d752"
SRC_URI[tokio-rustls-0.24.1.sha256sum] = "c28327cf380ac148141087fbfb9de9d7bd4e84ab5d2c28fbc911d753de8a7081"
SRC_URI[tokio-rustls-0.25.0.sha256sum] = "775e0c0f0adb3a2f22a00c4745d728b479985fc15ee7ca6a2608388c5569860f"
SRC_URI[tokio-rustls-0.26.0.sha256sum] = "0c7bc40d0e5a97695bb96e27995cd3a08538541b0a846f65bba7a359f36700d4"
SRC_URI[tokio-stream-0.1.16.sha256sum] = "4f4e6ce100d0eb49a2734f8c0812bcd324cf357d21810932c5df6b96ef2b86f1"
SRC_URI[tokio-tungstenite-0.24.0.sha256sum] = "edc5f74e248dc973e0dbb7b74c7e0d6fcc301c694ff50049504004ef4d0cdcd9"
SRC_URI[tokio-util-0.7.12.sha256sum] = "61e7c3654c13bcd040d4a03abee2c75b1d14a37b423cf5a813ceae1cc903ec6a"
SRC_URI[tokio-1.41.0.sha256sum] = "145f3413504347a2be84393cc8a7d2fb4d863b375909ea59f2158261aa258bbb"
SRC_URI[toml-0.8.19.sha256sum] = "a1ed1f98e3fdc28d6d910e6737ae6ab1a93bf1985935a1193e68f93eeb68d24e"
SRC_URI[toml_datetime-0.6.8.sha256sum] = "0dd7358ecb8fc2f8d014bf86f6f638ce72ba252a2c3a2572f2a795f1d23efb41"
SRC_URI[toml_edit-0.22.22.sha256sum] = "4ae48d6208a266e853d946088ed816055e556cc6028c5e8e2b84d9fa5dd7c7f5"
SRC_URI[tower-service-0.3.3.sha256sum] = "8df9b6e13f2d32c91b9bd719c00d1958837bc7dec474d94952798cc8e69eeec3"
SRC_URI[tracing-attributes-0.1.27.sha256sum] = "34704c8d6ebcbc939824180af020566b01a7c01f80641264eba0999f6c2b6be7"
SRC_URI[tracing-core-0.1.32.sha256sum] = "c06d3da6113f116aaee68e4d601191614c9053067f9ab7f6edbcb161237daa54"
SRC_URI[tracing-0.1.40.sha256sum] = "c3523ab5a71916ccf420eebdf5521fcef02141234bbc0b8a49f2fdc4544364ef"
SRC_URI[try-lock-0.2.5.sha256sum] = "e421abadd41a4225275504ea4d6566923418b7f05506fbc9c0fe86ba7396114b"
SRC_URI[tungstenite-0.24.0.sha256sum] = "18e5b8366ee7a95b16d32197d0b2604b43a0be89dc5fac9f8e96ccafbaedda8a"
SRC_URI[typenum-1.17.0.sha256sum] = "42ff0bf0c66b8238c6f3b578df37d0b7848e55df8577b3f74f92a69acceeb825"
SRC_URI[uds_windows-1.1.0.sha256sum] = "89daebc3e6fd160ac4aa9fc8b3bf71e1f74fbf92367ae71fb83a037e8bf164b9"
SRC_URI[unicode-bidi-0.3.17.sha256sum] = "5ab17db44d7388991a428b2ee655ce0c212e862eff1768a455c58f9aad6e7893"
SRC_URI[unicode-ident-1.0.13.sha256sum] = "e91b56cd4cadaeb79bbf1a5645f6b4f8dc5bde8834ad5894a8db35fda9efa1fe"
SRC_URI[unicode-normalization-0.1.24.sha256sum] = "5033c97c4262335cded6d6fc3e5c18ab755e1a3dc96376350f3d8e9f009ad956"
SRC_URI[unicode-width-0.1.14.sha256sum] = "7dd6e30e90baa6f72411720665d41d89b9a3d039dc45b8faea1ddd07f617f6af"
SRC_URI[untrusted-0.9.0.sha256sum] = "8ecb6da28b8a351d773b68d5825ac39017e680750f980f3a1a85cd8dd28a47c1"
SRC_URI[url-2.5.2.sha256sum] = "22784dbdf76fdde8af1aeda5622b546b422b6fc585325248a2bf9f5e41e94d6c"
SRC_URI[utf-8-0.7.6.sha256sum] = "09cc8ee72d2a9becf2f2febe0205bbed8fc6615b7cb429ad062dc7b7ddd036a9"
SRC_URI[utf8parse-0.2.2.sha256sum] = "06abde3611657adf66d383f00b093d7faecc7fa57071cce2578660c9f1010821"
SRC_URI[uuid-1.11.0.sha256sum] = "f8c5f0a0af699448548ad1a2fbf920fb4bee257eae39953ba95cb84891a0446a"
SRC_URI[vergen-gitcl-1.0.1.sha256sum] = "2a3a7f91caabecefc3c249fd864b11d4abe315c166fbdb568964421bccfd2b7a"
SRC_URI[vergen-lib-0.1.4.sha256sum] = "229eaddb0050920816cf051e619affaf18caa3dd512de8de5839ccbc8e53abb0"
SRC_URI[vergen-9.0.1.sha256sum] = "349ed9e45296a581f455bc18039878f409992999bc1d5da12a6800eb18c8752f"
SRC_URI[version-compare-0.1.1.sha256sum] = "579a42fc0b8e0c63b76519a339be31bed574929511fa53c1a3acae26eb258f29"
SRC_URI[version-compare-0.2.0.sha256sum] = "852e951cb7832cb45cb1169900d19760cfa39b82bc0ea9c0e5a14ae88411c98b"
SRC_URI[version_check-0.9.5.sha256sum] = "0b928f33d975fc6ad9f86c8f283853ad26bdd5b10b7f1542aa2fa15e2289105a"
SRC_URI[walkdir-2.5.0.sha256sum] = "29790946404f91d9c5d06f9874efddea1dc06c5efe94541a7d6863108e3a5e4b"
SRC_URI[want-0.3.1.sha256sum] = "bfa7760aed19e106de2c7c0b581b509f2f25d3dacaf737cb82ac61bc6d760b0e"
SRC_URI[wasi-0.11.0+wasi-snapshot-preview1.sha256sum] = "9c8d87e72b64a3b4db28d11ce29237c246188f4f51057d65a7eab63b7987e423"
SRC_URI[wasm-bindgen-backend-0.2.95.sha256sum] = "cb6dd4d3ca0ddffd1dd1c9c04f94b868c37ff5fac97c30b97cff2d74fce3a358"
SRC_URI[wasm-bindgen-futures-0.4.45.sha256sum] = "cc7ec4f8827a71586374db3e87abdb5a2bb3a15afed140221307c3ec06b1f63b"
SRC_URI[wasm-bindgen-macro-support-0.2.95.sha256sum] = "26c6ab57572f7a24a4985830b120de1594465e5d500f24afe89e16b4e833ef68"
SRC_URI[wasm-bindgen-macro-0.2.95.sha256sum] = "e79384be7f8f5a9dd5d7167216f022090cf1f9ec128e6e6a482a2cb5c5422c56"
SRC_URI[wasm-bindgen-shared-0.2.95.sha256sum] = "65fc09f10666a9f147042251e0dda9c18f166ff7de300607007e96bdebc1068d"
SRC_URI[wasm-bindgen-0.2.95.sha256sum] = "128d1e363af62632b8eb57219c8fd7877144af57558fb2ef0368d0087bddeb2e"
SRC_URI[web-sys-0.3.72.sha256sum] = "f6488b90108c040df0fe62fa815cbdee25124641df01814dd7282749234c6112"
SRC_URI[webpki-roots-0.25.4.sha256sum] = "5f20c57d8d7db6d3b86154206ae5d8fba62dd39573114de97c2cb0578251f8e1"
SRC_URI[webpki-0.22.4.sha256sum] = "ed63aea5ce73d0ff405984102c42de94fc55a6b75765d621c65262469b3c9b53"
SRC_URI[which-4.4.2.sha256sum] = "87ba24419a2078cd2b0f2ede2691b6c66d8e47836da3b6db8265ebad47afbfc7"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.9.sha256sum] = "cf221c93e13a30d793f7645a0e7762c55d169dbb0a49671918a2319d289b10bb"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-core-0.52.0.sha256sum] = "33ab640c8d7e35bf8ba19b884ba838ceb4fba93a4e8c65a9059d08afcfc683d9"
SRC_URI[windows-core-0.54.0.sha256sum] = "12661b9c89351d684a50a8a643ce5f608e20243b9fb84687800163429f161d65"
SRC_URI[windows-core-0.57.0.sha256sum] = "d2ed2439a290666cd67ecce2b0ffaad89c2a56b976b736e6ece670297897832d"
SRC_URI[windows-implement-0.57.0.sha256sum] = "9107ddc059d5b6fbfbffdfa7a7fe3e22a226def0b2608f72e9d552763d3e1ad7"
SRC_URI[windows-interface-0.57.0.sha256sum] = "29bee4b38ea3cde66011baa44dba677c432a78593e202392d1e9070cf2a7fca7"
SRC_URI[windows-result-0.1.2.sha256sum] = "5e383302e8ec8515204254685643de10811af0ed97ea37210dc26fb0032647f8"
SRC_URI[windows-sys-0.45.0.sha256sum] = "75283be5efb2831d37ea142365f009c02ec203cd29a3ebecbc093d52315b66d0"
SRC_URI[windows-sys-0.48.0.sha256sum] = "677d2418bec65e3338edb076e806bc1ec15693c5d0104683f2efe857f61056a9"
SRC_URI[windows-sys-0.52.0.sha256sum] = "282be5f36a8ce781fad8c8ae18fa3f9beff57ec1b52cb3de0789201425d9a33d"
SRC_URI[windows-sys-0.59.0.sha256sum] = "1e38bc4d79ed67fd075bcc251a1c39b32a1776bbe92e5bef1f0bf1f8c531853b"
SRC_URI[windows-targets-0.42.2.sha256sum] = "8e5180c00cd44c9b1c88adb3693291f1cd93605ded80c250a75d472756b4d071"
SRC_URI[windows-targets-0.48.5.sha256sum] = "9a2fa6e2155d7247be68c096456083145c183cbbbc2764150dda45a87197940c"
SRC_URI[windows-targets-0.52.6.sha256sum] = "9b724f72796e036ab90c1021d4780d4d3d648aca59e491e6b98e725b84e99973"
SRC_URI[windows-0.52.0.sha256sum] = "e48a53791691ab099e5e2ad123536d0fff50652600abaf43bbf952894110d0be"
SRC_URI[windows-0.54.0.sha256sum] = "9252e5725dbed82865af151df558e754e4a3c2c30818359eb17465f1346a1b49"
SRC_URI[windows-0.57.0.sha256sum] = "12342cb4d8e3b046f3d80effd474a7a02447231330ef77d71daa6fbc40681143"
SRC_URI[windows_aarch64_gnullvm-0.42.2.sha256sum] = "597a5118570b68bc08d8d59125332c54f1ba9d9adeedeef5b99b02ba2b0698f8"
SRC_URI[windows_aarch64_gnullvm-0.48.5.sha256sum] = "2b38e32f0abccf9987a4e3079dfb67dcd799fb61361e53e2882c3cbaf0d905d8"
SRC_URI[windows_aarch64_gnullvm-0.52.6.sha256sum] = "32a4622180e7a0ec044bb555404c800bc9fd9ec262ec147edd5989ccd0c02cd3"
SRC_URI[windows_aarch64_msvc-0.42.2.sha256sum] = "e08e8864a60f06ef0d0ff4ba04124db8b0fb3be5776a5cd47641e942e58c4d43"
SRC_URI[windows_aarch64_msvc-0.48.5.sha256sum] = "dc35310971f3b2dbbf3f0690a219f40e2d9afcf64f9ab7cc1be722937c26b4bc"
SRC_URI[windows_aarch64_msvc-0.52.6.sha256sum] = "09ec2a7bb152e2252b53fa7803150007879548bc709c039df7627cabbd05d469"
SRC_URI[windows_i686_gnu-0.42.2.sha256sum] = "c61d927d8da41da96a81f029489353e68739737d3beca43145c8afec9a31a84f"
SRC_URI[windows_i686_gnu-0.48.5.sha256sum] = "a75915e7def60c94dcef72200b9a8e58e5091744960da64ec734a6c6e9b3743e"
SRC_URI[windows_i686_gnu-0.52.6.sha256sum] = "8e9b5ad5ab802e97eb8e295ac6720e509ee4c243f69d781394014ebfe8bbfa0b"
SRC_URI[windows_i686_gnullvm-0.52.6.sha256sum] = "0eee52d38c090b3caa76c563b86c3a4bd71ef1a819287c19d586d7334ae8ed66"
SRC_URI[windows_i686_msvc-0.42.2.sha256sum] = "44d840b6ec649f480a41c8d80f9c65108b92d89345dd94027bfe06ac444d1060"
SRC_URI[windows_i686_msvc-0.48.5.sha256sum] = "8f55c233f70c4b27f66c523580f78f1004e8b5a8b659e05a4eb49d4166cca406"
SRC_URI[windows_i686_msvc-0.52.6.sha256sum] = "240948bc05c5e7c6dabba28bf89d89ffce3e303022809e73deaefe4f6ec56c66"
SRC_URI[windows_x86_64_gnu-0.42.2.sha256sum] = "8de912b8b8feb55c064867cf047dda097f92d51efad5b491dfb98f6bbb70cb36"
SRC_URI[windows_x86_64_gnu-0.48.5.sha256sum] = "53d40abd2583d23e4718fddf1ebec84dbff8381c07cae67ff7768bbf19c6718e"
SRC_URI[windows_x86_64_gnu-0.52.6.sha256sum] = "147a5c80aabfbf0c7d901cb5895d1de30ef2907eb21fbbab29ca94c5b08b1a78"
SRC_URI[windows_x86_64_gnullvm-0.42.2.sha256sum] = "26d41b46a36d453748aedef1486d5c7a85db22e56aff34643984ea85514e94a3"
SRC_URI[windows_x86_64_gnullvm-0.48.5.sha256sum] = "0b7b52767868a23d5bab768e390dc5f5c55825b6d30b86c844ff2dc7414044cc"
SRC_URI[windows_x86_64_gnullvm-0.52.6.sha256sum] = "24d5b23dc417412679681396f2b49f3de8c1473deb516bd34410872eff51ed0d"
SRC_URI[windows_x86_64_msvc-0.42.2.sha256sum] = "9aec5da331524158c6d1a4ac0ab1541149c0b9505fde06423b02f5ef0106b9f0"
SRC_URI[windows_x86_64_msvc-0.48.5.sha256sum] = "ed94fce61571a4006852b7389a063ab983c02eb1bb37b47f8272ce92d06d9538"
SRC_URI[windows_x86_64_msvc-0.52.6.sha256sum] = "589f6da84c646204747d1270a2a5661ea66ed1cced2631d546fdfb155959f9ec"
SRC_URI[winnow-0.6.20.sha256sum] = "36c1fec1a2bb5866f07c25f68c26e565c4c200aebb96d7e55710c19d3e8ac49b"
SRC_URI[winreg-0.50.0.sha256sum] = "524e57b2c537c0f9b1e69f1965311ec12182b4122e45035b1508cd24d2adadb1"
SRC_URI[xdg-home-1.3.0.sha256sum] = "ec1cdab258fb55c0da61328dc52c8764709b249011b2cad0454c72f0bf10a1f6"
SRC_URI[zbus-4.4.0.sha256sum] = "bb97012beadd29e654708a0fdb4c84bc046f537aecfde2c3ee0a9e4b4d48c725"
SRC_URI[zbus_macros-4.4.0.sha256sum] = "267db9407081e90bbfa46d841d3cbc60f59c0351838c4bc65199ecd79ab1983e"
SRC_URI[zbus_names-3.0.0.sha256sum] = "4b9b1fef7d021261cc16cba64c351d291b715febe0fa10dc3a443ac5a5022e6c"
SRC_URI[zerocopy-derive-0.7.35.sha256sum] = "fa4f8080344d4671fb4e831a13ad1e68092748387dfc4f55e356242fae12ce3e"
SRC_URI[zerocopy-0.7.35.sha256sum] = "1b9b4fd18abc82b8136838da5d50bae7bdea537c574d8dc1a34ed098d6c166f0"
SRC_URI[zeroize-1.8.1.sha256sum] = "ced3678a2879b30306d323f4542626697a464a97c0a07c9aebf7ebca65cd4dde"
SRC_URI[zvariant-4.2.0.sha256sum] = "2084290ab9a1c471c38fc524945837734fbf124487e105daec2bb57fd48c81fe"
SRC_URI[zvariant_derive-4.2.0.sha256sum] = "73e2ba546bda683a90652bac4a279bc146adad1386f25379cf73200d2002c449"
SRC_URI[zvariant_utils-2.1.0.sha256sum] = "c51bcff7cc3dbb5055396bcf774748c3dab426b4b8659046963523cee4808340"

# FIXME: update generateme with the real MD5 of the license file
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=98b2b0c9a6081259c441045ca68b640f \
"

SUMMARY = "An open source client library for Spotify, with support for Spotify Connect"
HOMEPAGE = "https://github.com/librespot-org/librespot"
LICENSE = "MIT"
