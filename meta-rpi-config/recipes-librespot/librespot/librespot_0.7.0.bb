inherit cargo

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get librespot could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/librespot/v0.7.0"
SRC_URI += "git://github.com/MrTarantoga/librespot.git;protocol=https;nobranch=1"
SRCREV = "99092dc78c13f5c14b46b4e1d1c0052a3e03435a"

S = "${WORKDIR}/git"

CARGO_SRC_DIR = ""
CARGO_BUILD_FLAGS:append = " --no-default-features --features rustls-tls-native-roots --features with-libmdns --features pulseaudio-backend"


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
    crate://crates.io/adler2/2.0.1 \
    crate://crates.io/aes/0.8.4 \
    crate://crates.io/aho-corasick/1.1.3 \
    crate://crates.io/allocator-api2/0.2.21 \
    crate://crates.io/alsa-sys/0.3.1 \
    crate://crates.io/alsa/0.9.2 \
    crate://crates.io/android-tzdata/0.1.1 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/anstream/0.6.20 \
    crate://crates.io/anstyle-parse/0.2.7 \
    crate://crates.io/anstyle-query/1.1.4 \
    crate://crates.io/anstyle-wincon/3.0.10 \
    crate://crates.io/anstyle/1.0.11 \
    crate://crates.io/anyhow/1.0.99 \
    crate://crates.io/arrayvec/0.7.6 \
    crate://crates.io/async-broadcast/0.7.2 \
    crate://crates.io/async-recursion/1.1.1 \
    crate://crates.io/async-trait/0.1.89 \
    crate://crates.io/atomic-waker/1.1.2 \
    crate://crates.io/atomic_refcell/0.1.13 \
    crate://crates.io/autocfg/1.5.0 \
    crate://crates.io/backtrace/0.3.75 \
    crate://crates.io/base64/0.22.1 \
    crate://crates.io/base64ct/1.7.3 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitflags/2.9.3 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/bumpalo/3.19.0 \
    crate://crates.io/bytemuck/1.23.2 \
    crate://crates.io/byteorder/1.5.0 \
    crate://crates.io/bytes/1.10.1 \
    crate://crates.io/cc/1.2.34 \
    crate://crates.io/cesu8/1.1.0 \
    crate://crates.io/cfg-expr/0.18.0 \
    crate://crates.io/cfg-if/1.0.3 \
    crate://crates.io/cfg_aliases/0.2.1 \
    crate://crates.io/chrono/0.4.41 \
    crate://crates.io/cipher/0.4.4 \
    crate://crates.io/colorchoice/1.0.4 \
    crate://crates.io/combine/4.6.7 \
    crate://crates.io/concurrent-queue/2.5.0 \
    crate://crates.io/const-oid/0.9.6 \
    crate://crates.io/core-foundation-sys/0.8.7 \
    crate://crates.io/core-foundation/0.10.1 \
    crate://crates.io/core-foundation/0.9.4 \
    crate://crates.io/coreaudio-rs/0.13.0 \
    crate://crates.io/cpal/0.16.0 \
    crate://crates.io/cpufeatures/0.2.17 \
    crate://crates.io/crc32fast/1.5.0 \
    crate://crates.io/crossbeam-utils/0.8.21 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/ctr/0.9.2 \
    crate://crates.io/darling/0.20.11 \
    crate://crates.io/darling_core/0.20.11 \
    crate://crates.io/darling_macro/0.20.11 \
    crate://crates.io/dasp_sample/0.11.0 \
    crate://crates.io/data-encoding/2.9.0 \
    crate://crates.io/der/0.7.10 \
    crate://crates.io/deranged/0.4.0 \
    crate://crates.io/derive_builder/0.20.2 \
    crate://crates.io/derive_builder_core/0.20.2 \
    crate://crates.io/derive_builder_macro/0.20.2 \
    crate://crates.io/digest/0.10.7 \
    crate://crates.io/dispatch2/0.3.0 \
    crate://crates.io/displaydoc/0.2.5 \
    crate://crates.io/dns-sd/0.1.3 \
    crate://crates.io/either/1.15.0 \
    crate://crates.io/encoding_rs/0.8.35 \
    crate://crates.io/endi/1.1.0 \
    crate://crates.io/enumflags2/0.7.12 \
    crate://crates.io/enumflags2_derive/0.7.12 \
    crate://crates.io/env_filter/0.1.3 \
    crate://crates.io/env_logger/0.11.8 \
    crate://crates.io/equivalent/1.0.2 \
    crate://crates.io/errno/0.3.13 \
    crate://crates.io/event-listener-strategy/0.5.4 \
    crate://crates.io/event-listener/5.4.1 \
    crate://crates.io/fastrand/2.3.0 \
    crate://crates.io/fixedbitset/0.4.2 \
    crate://crates.io/flate2/1.1.2 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/foldhash/0.1.5 \
    crate://crates.io/foreign-types-shared/0.1.1 \
    crate://crates.io/foreign-types/0.3.2 \
    crate://crates.io/form_urlencoded/1.2.2 \
    crate://crates.io/futures-channel/0.3.31 \
    crate://crates.io/futures-core/0.3.31 \
    crate://crates.io/futures-executor/0.3.31 \
    crate://crates.io/futures-io/0.3.31 \
    crate://crates.io/futures-lite/2.6.1 \
    crate://crates.io/futures-macro/0.3.31 \
    crate://crates.io/futures-sink/0.3.31 \
    crate://crates.io/futures-task/0.3.31 \
    crate://crates.io/futures-timer/3.0.3 \
    crate://crates.io/futures-util/0.3.31 \
    crate://crates.io/futures/0.3.31 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getopts/0.2.23 \
    crate://crates.io/getrandom/0.2.16 \
    crate://crates.io/getrandom/0.3.3 \
    crate://crates.io/gimli/0.31.1 \
    crate://crates.io/gio-sys/0.21.1 \
    crate://crates.io/glib-macros/0.21.0 \
    crate://crates.io/glib-sys/0.21.1 \
    crate://crates.io/glib/0.21.1 \
    crate://crates.io/gobject-sys/0.21.1 \
    crate://crates.io/governor/0.10.1 \
    crate://crates.io/gstreamer-app-sys/0.24.0 \
    crate://crates.io/gstreamer-app/0.24.0 \
    crate://crates.io/gstreamer-audio-sys/0.24.0 \
    crate://crates.io/gstreamer-audio/0.24.0 \
    crate://crates.io/gstreamer-base-sys/0.24.0 \
    crate://crates.io/gstreamer-base/0.24.0 \
    crate://crates.io/gstreamer-sys/0.24.0 \
    crate://crates.io/gstreamer/0.24.1 \
    crate://crates.io/h2/0.4.12 \
    crate://crates.io/hashbrown/0.15.5 \
    crate://crates.io/headers-core/0.3.0 \
    crate://crates.io/headers/0.4.1 \
    crate://crates.io/heck/0.5.0 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hmac/0.12.1 \
    crate://crates.io/home/0.5.11 \
    crate://crates.io/hostname/0.4.1 \
    crate://crates.io/http-body-util/0.1.3 \
    crate://crates.io/http-body/1.0.1 \
    crate://crates.io/http/1.3.1 \
    crate://crates.io/httparse/1.10.1 \
    crate://crates.io/httpdate/1.0.3 \
    crate://crates.io/hyper-proxy2/0.1.0 \
    crate://crates.io/hyper-rustls/0.26.0 \
    crate://crates.io/hyper-rustls/0.27.7 \
    crate://crates.io/hyper-tls/0.6.0 \
    crate://crates.io/hyper-util/0.1.16 \
    crate://crates.io/hyper/1.7.0 \
    crate://crates.io/iana-time-zone-haiku/0.1.2 \
    crate://crates.io/iana-time-zone/0.1.63 \
    crate://crates.io/icu_collections/2.0.0 \
    crate://crates.io/icu_locale_core/2.0.0 \
    crate://crates.io/icu_normalizer/2.0.0 \
    crate://crates.io/icu_normalizer_data/2.0.0 \
    crate://crates.io/icu_properties/2.0.1 \
    crate://crates.io/icu_properties_data/2.0.1 \
    crate://crates.io/icu_provider/2.0.0 \
    crate://crates.io/ident_case/1.0.1 \
    crate://crates.io/idna/1.1.0 \
    crate://crates.io/idna_adapter/1.2.1 \
    crate://crates.io/if-addrs/0.12.0 \
    crate://crates.io/indexmap/2.11.0 \
    crate://crates.io/inout/0.1.4 \
    crate://crates.io/io-uring/0.7.10 \
    crate://crates.io/ipnet/2.11.0 \
    crate://crates.io/iri-string/0.7.8 \
    crate://crates.io/is-docker/0.2.0 \
    crate://crates.io/is-wsl/0.4.0 \
    crate://crates.io/is_terminal_polyfill/1.70.1 \
    crate://crates.io/itertools/0.14.0 \
    crate://crates.io/itoa/1.0.15 \
    crate://crates.io/jack-sys/0.5.1 \
    crate://crates.io/jack/0.13.3 \
    crate://crates.io/jiff-static/0.2.15 \
    crate://crates.io/jiff/0.2.15 \
    crate://crates.io/jni-sys/0.3.0 \
    crate://crates.io/jni/0.21.1 \
    crate://crates.io/js-sys/0.3.77 \
    crate://crates.io/kstring/2.0.2 \
    crate://crates.io/lazy_static/1.5.0 \
    crate://crates.io/libc/0.2.175 \
    crate://crates.io/libloading/0.7.4 \
    crate://crates.io/libm/0.2.15 \
    crate://crates.io/libmdns/0.9.1 \
    crate://crates.io/libpulse-binding/2.30.1 \
    crate://crates.io/libpulse-simple-binding/2.29.0 \
    crate://crates.io/libpulse-simple-sys/1.22.0 \
    crate://crates.io/libpulse-sys/1.23.0 \
    crate://crates.io/linux-raw-sys/0.4.15 \
    crate://crates.io/linux-raw-sys/0.9.4 \
    crate://crates.io/litemap/0.8.0 \
    crate://crates.io/lock_api/0.4.13 \
    crate://crates.io/log/0.4.27 \
    crate://crates.io/lru-slab/0.1.2 \
    crate://crates.io/mach2/0.4.3 \
    crate://crates.io/memchr/2.7.5 \
    crate://crates.io/memoffset/0.9.1 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/miniz_oxide/0.8.9 \
    crate://crates.io/mio/1.0.4 \
    crate://crates.io/muldiv/1.0.1 \
    crate://crates.io/multimap/0.10.1 \
    crate://crates.io/native-tls/0.2.14 \
    crate://crates.io/ndk-context/0.1.1 \
    crate://crates.io/ndk-sys/0.6.0+11769913 \
    crate://crates.io/ndk/0.9.0 \
    crate://crates.io/nix/0.30.1 \
    crate://crates.io/nonzero_ext/0.3.0 \
    crate://crates.io/ntapi/0.4.1 \
    crate://crates.io/num-bigint-dig/0.8.4 \
    crate://crates.io/num-bigint/0.4.6 \
    crate://crates.io/num-conv/0.1.0 \
    crate://crates.io/num-derive/0.4.2 \
    crate://crates.io/num-integer/0.1.46 \
    crate://crates.io/num-iter/0.1.45 \
    crate://crates.io/num-rational/0.4.2 \
    crate://crates.io/num-traits/0.2.19 \
    crate://crates.io/num_enum/0.7.4 \
    crate://crates.io/num_enum_derive/0.7.4 \
    crate://crates.io/num_threads/0.1.7 \
    crate://crates.io/oauth2/5.0.0 \
    crate://crates.io/objc2-audio-toolbox/0.3.1 \
    crate://crates.io/objc2-core-audio-types/0.3.1 \
    crate://crates.io/objc2-core-audio/0.3.1 \
    crate://crates.io/objc2-core-foundation/0.3.1 \
    crate://crates.io/objc2-encode/4.1.0 \
    crate://crates.io/objc2-foundation/0.3.1 \
    crate://crates.io/objc2-io-kit/0.3.1 \
    crate://crates.io/objc2/0.6.2 \
    crate://crates.io/object/0.36.7 \
    crate://crates.io/ogg/0.9.2 \
    crate://crates.io/once_cell/1.21.3 \
    crate://crates.io/once_cell_polyfill/1.70.1 \
    crate://crates.io/open/5.3.2 \
    crate://crates.io/openssl-macros/0.1.1 \
    crate://crates.io/openssl-probe/0.1.6 \
    crate://crates.io/openssl-sys/0.9.109 \
    crate://crates.io/openssl/0.10.73 \
    crate://crates.io/option-operations/0.5.0 \
    crate://crates.io/ordered-stream/0.2.0 \
    crate://crates.io/parking/2.2.1 \
    crate://crates.io/parking_lot/0.12.4 \
    crate://crates.io/parking_lot_core/0.9.11 \
    crate://crates.io/paste/1.0.15 \
    crate://crates.io/pathdiff/0.2.3 \
    crate://crates.io/pbkdf2/0.12.2 \
    crate://crates.io/pem-rfc7468/0.7.0 \
    crate://crates.io/percent-encoding/2.3.2 \
    crate://crates.io/petgraph/0.6.5 \
    crate://crates.io/pin-project-lite/0.2.16 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkcs1/0.7.5 \
    crate://crates.io/pkcs8/0.10.2 \
    crate://crates.io/pkg-config/0.3.32 \
    crate://crates.io/portable-atomic-util/0.2.4 \
    crate://crates.io/portable-atomic/1.11.1 \
    crate://crates.io/portaudio-rs/0.3.2 \
    crate://crates.io/portaudio-sys/0.1.1 \
    crate://crates.io/potential_utf/0.1.2 \
    crate://crates.io/powerfmt/0.2.0 \
    crate://crates.io/ppv-lite86/0.2.21 \
    crate://crates.io/priority-queue/2.5.0 \
    crate://crates.io/proc-macro-crate/3.3.0 \
    crate://crates.io/proc-macro2/1.0.101 \
    crate://crates.io/protobuf-codegen/3.7.2 \
    crate://crates.io/protobuf-json-mapping/3.7.2 \
    crate://crates.io/protobuf-parse/3.7.2 \
    crate://crates.io/protobuf-support/3.7.2 \
    crate://crates.io/protobuf/3.7.2 \
    crate://crates.io/quick-xml/0.38.3 \
    crate://crates.io/quinn-proto/0.11.12 \
    crate://crates.io/quinn-udp/0.5.13 \
    crate://crates.io/quinn/0.11.8 \
    crate://crates.io/quote/1.0.40 \
    crate://crates.io/r-efi/5.3.0 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand/0.9.2 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_chacha/0.9.0 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rand_core/0.9.3 \
    crate://crates.io/rand_distr/0.5.1 \
    crate://crates.io/redox_syscall/0.5.17 \
    crate://crates.io/regex-automata/0.4.10 \
    crate://crates.io/regex-syntax/0.8.6 \
    crate://crates.io/regex/1.11.2 \
    crate://crates.io/reqwest/0.12.23 \
    crate://crates.io/ring/0.17.14 \
    crate://crates.io/rodio/0.21.1 \
    crate://crates.io/rsa/0.9.8 \
    crate://crates.io/rustc-demangle/0.1.26 \
    crate://crates.io/rustc-hash/2.1.1 \
    crate://crates.io/rustix/0.38.44 \
    crate://crates.io/rustix/1.0.8 \
    crate://crates.io/rustls-native-certs/0.7.3 \
    crate://crates.io/rustls-native-certs/0.8.1 \
    crate://crates.io/rustls-pemfile/2.2.0 \
    crate://crates.io/rustls-pki-types/1.12.0 \
    crate://crates.io/rustls-webpki/0.102.8 \
    crate://crates.io/rustls-webpki/0.103.4 \
    crate://crates.io/rustls/0.22.4 \
    crate://crates.io/rustls/0.23.31 \
    crate://crates.io/rustversion/1.0.22 \
    crate://crates.io/ryu/1.0.20 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/schannel/0.1.27 \
    crate://crates.io/scopeguard/1.2.0 \
    crate://crates.io/sdl2-sys/0.38.0 \
    crate://crates.io/sdl2/0.38.0 \
    crate://crates.io/security-framework-sys/2.14.0 \
    crate://crates.io/security-framework/2.11.1 \
    crate://crates.io/security-framework/3.3.0 \
    crate://crates.io/serde/1.0.219 \
    crate://crates.io/serde_derive/1.0.219 \
    crate://crates.io/serde_json/1.0.143 \
    crate://crates.io/serde_path_to_error/0.1.17 \
    crate://crates.io/serde_repr/0.1.20 \
    crate://crates.io/serde_spanned/0.6.9 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/sha1/0.10.6 \
    crate://crates.io/sha2/0.10.9 \
    crate://crates.io/shannon/0.2.0 \
    crate://crates.io/shell-words/1.1.0 \
    crate://crates.io/shlex/1.3.0 \
    crate://crates.io/signal-hook-registry/1.4.6 \
    crate://crates.io/signature/2.2.0 \
    crate://crates.io/slab/0.4.11 \
    crate://crates.io/smallvec/1.15.1 \
    crate://crates.io/socket2/0.5.10 \
    crate://crates.io/socket2/0.6.0 \
    crate://crates.io/spin/0.9.8 \
    crate://crates.io/spinning_top/0.3.0 \
    crate://crates.io/spki/0.7.3 \
    crate://crates.io/stable_deref_trait/1.2.0 \
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
    crate://crates.io/syn/2.0.106 \
    crate://crates.io/sync_wrapper/1.0.2 \
    crate://crates.io/synstructure/0.13.2 \
    crate://crates.io/sysinfo/0.36.1 \
    crate://crates.io/system-configuration-sys/0.6.0 \
    crate://crates.io/system-configuration/0.6.1 \
    crate://crates.io/system-deps/7.0.5 \
    crate://crates.io/target-lexicon/0.13.2 \
    crate://crates.io/tempfile/3.21.0 \
    crate://crates.io/thiserror-impl/1.0.69 \
    crate://crates.io/thiserror-impl/2.0.16 \
    crate://crates.io/thiserror/1.0.69 \
    crate://crates.io/thiserror/2.0.16 \
    crate://crates.io/thread-id/4.2.2 \
    crate://crates.io/time-core/0.1.4 \
    crate://crates.io/time-macros/0.2.22 \
    crate://crates.io/time/0.3.41 \
    crate://crates.io/tinystr/0.8.1 \
    crate://crates.io/tinyvec/1.10.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio-macros/2.5.0 \
    crate://crates.io/tokio-native-tls/0.3.1 \
    crate://crates.io/tokio-rustls/0.25.0 \
    crate://crates.io/tokio-rustls/0.26.2 \
    crate://crates.io/tokio-stream/0.1.17 \
    crate://crates.io/tokio-tungstenite/0.27.0 \
    crate://crates.io/tokio-util/0.7.16 \
    crate://crates.io/tokio/1.47.1 \
    crate://crates.io/toml/0.8.23 \
    crate://crates.io/toml_datetime/0.6.11 \
    crate://crates.io/toml_edit/0.22.27 \
    crate://crates.io/tower-http/0.6.6 \
    crate://crates.io/tower-layer/0.3.3 \
    crate://crates.io/tower-service/0.3.3 \
    crate://crates.io/tower/0.5.2 \
    crate://crates.io/tracing-attributes/0.1.30 \
    crate://crates.io/tracing-core/0.1.34 \
    crate://crates.io/tracing/0.1.41 \
    crate://crates.io/try-lock/0.2.5 \
    crate://crates.io/tungstenite/0.27.0 \
    crate://crates.io/typenum/1.18.0 \
    crate://crates.io/uds_windows/1.1.0 \
    crate://crates.io/unicode-ident/1.0.18 \
    crate://crates.io/unicode-width/0.2.1 \
    crate://crates.io/untrusted/0.9.0 \
    crate://crates.io/url/2.5.7 \
    crate://crates.io/utf-8/0.7.6 \
    crate://crates.io/utf8_iter/1.0.4 \
    crate://crates.io/utf8parse/0.2.2 \
    crate://crates.io/uuid/1.18.0 \
    crate://crates.io/vcpkg/0.2.15 \
    crate://crates.io/vergen-gitcl/1.0.8 \
    crate://crates.io/vergen-lib/0.1.6 \
    crate://crates.io/vergen/9.0.6 \
    crate://crates.io/version-compare/0.1.1 \
    crate://crates.io/version-compare/0.2.0 \
    crate://crates.io/version_check/0.9.5 \
    crate://crates.io/walkdir/2.5.0 \
    crate://crates.io/want/0.3.1 \
    crate://crates.io/wasi/0.11.1+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.14.2+wasi-0.2.4 \
    crate://crates.io/wasm-bindgen-backend/0.2.100 \
    crate://crates.io/wasm-bindgen-futures/0.4.50 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.100 \
    crate://crates.io/wasm-bindgen-macro/0.2.100 \
    crate://crates.io/wasm-bindgen-shared/0.2.100 \
    crate://crates.io/wasm-bindgen/0.2.100 \
    crate://crates.io/web-sys/0.3.77 \
    crate://crates.io/web-time/1.1.0 \
    crate://crates.io/webpki-roots/0.26.11 \
    crate://crates.io/webpki-roots/1.0.2 \
    crate://crates.io/webpki/0.22.4 \
    crate://crates.io/which/4.4.2 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.10 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-collections/0.2.0 \
    crate://crates.io/windows-core/0.54.0 \
    crate://crates.io/windows-core/0.61.2 \
    crate://crates.io/windows-future/0.2.1 \
    crate://crates.io/windows-implement/0.60.0 \
    crate://crates.io/windows-interface/0.59.1 \
    crate://crates.io/windows-link/0.1.3 \
    crate://crates.io/windows-numerics/0.2.0 \
    crate://crates.io/windows-registry/0.5.3 \
    crate://crates.io/windows-result/0.1.2 \
    crate://crates.io/windows-result/0.3.4 \
    crate://crates.io/windows-strings/0.4.2 \
    crate://crates.io/windows-sys/0.45.0 \
    crate://crates.io/windows-sys/0.52.0 \
    crate://crates.io/windows-sys/0.59.0 \
    crate://crates.io/windows-sys/0.60.2 \
    crate://crates.io/windows-targets/0.42.2 \
    crate://crates.io/windows-targets/0.52.6 \
    crate://crates.io/windows-targets/0.53.3 \
    crate://crates.io/windows-threading/0.1.0 \
    crate://crates.io/windows/0.54.0 \
    crate://crates.io/windows/0.61.3 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.2 \
    crate://crates.io/windows_aarch64_gnullvm/0.52.6 \
    crate://crates.io/windows_aarch64_gnullvm/0.53.0 \
    crate://crates.io/windows_aarch64_msvc/0.42.2 \
    crate://crates.io/windows_aarch64_msvc/0.52.6 \
    crate://crates.io/windows_aarch64_msvc/0.53.0 \
    crate://crates.io/windows_i686_gnu/0.42.2 \
    crate://crates.io/windows_i686_gnu/0.52.6 \
    crate://crates.io/windows_i686_gnu/0.53.0 \
    crate://crates.io/windows_i686_gnullvm/0.52.6 \
    crate://crates.io/windows_i686_gnullvm/0.53.0 \
    crate://crates.io/windows_i686_msvc/0.42.2 \
    crate://crates.io/windows_i686_msvc/0.52.6 \
    crate://crates.io/windows_i686_msvc/0.53.0 \
    crate://crates.io/windows_x86_64_gnu/0.42.2 \
    crate://crates.io/windows_x86_64_gnu/0.52.6 \
    crate://crates.io/windows_x86_64_gnu/0.53.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.2 \
    crate://crates.io/windows_x86_64_gnullvm/0.52.6 \
    crate://crates.io/windows_x86_64_gnullvm/0.53.0 \
    crate://crates.io/windows_x86_64_msvc/0.42.2 \
    crate://crates.io/windows_x86_64_msvc/0.52.6 \
    crate://crates.io/windows_x86_64_msvc/0.53.0 \
    crate://crates.io/winnow/0.7.13 \
    crate://crates.io/wit-bindgen-rt/0.39.0 \
    crate://crates.io/writeable/0.6.1 \
    crate://crates.io/yoke-derive/0.8.0 \
    crate://crates.io/yoke/0.8.0 \
    crate://crates.io/zbus/5.10.0 \
    crate://crates.io/zbus_macros/5.10.0 \
    crate://crates.io/zbus_names/4.2.0 \
    crate://crates.io/zerocopy-derive/0.8.26 \
    crate://crates.io/zerocopy/0.8.26 \
    crate://crates.io/zerofrom-derive/0.1.6 \
    crate://crates.io/zerofrom/0.1.6 \
    crate://crates.io/zeroize/1.8.1 \
    crate://crates.io/zerotrie/0.2.2 \
    crate://crates.io/zerovec-derive/0.11.1 \
    crate://crates.io/zerovec/0.11.4 \
    crate://crates.io/zvariant/5.7.0 \
    crate://crates.io/zvariant_derive/5.7.0 \
    crate://crates.io/zvariant_utils/3.2.1 \
"

SRC_URI[addr2line-0.24.2.sha256sum] = "dfbe277e56a376000877090da837660b4427aad530e3028d44e0bffe4f89a1c1"
SRC_URI[adler2-2.0.1.sha256sum] = "320119579fcad9c21884f5c4861d16174d0e06250625266f50fe6898340abefa"
SRC_URI[aes-0.8.4.sha256sum] = "b169f7a6d4742236a0a00c541b845991d0ac43e546831af1249753ab4c3aa3a0"
SRC_URI[aho-corasick-1.1.3.sha256sum] = "8e60d3430d3a69478ad0993f19238d2df97c507009a52b3c10addcd7f6bcb916"
SRC_URI[allocator-api2-0.2.21.sha256sum] = "683d7910e743518b0e34f1186f92494becacb047c7b6bf616c96772180fef923"
SRC_URI[alsa-sys-0.3.1.sha256sum] = "db8fee663d06c4e303404ef5f40488a53e062f89ba8bfed81f42325aafad1527"
SRC_URI[alsa-0.9.2.sha256sum] = "bdc00893e7a970727e9304671b2c88577b4cfe53dc64019fdfdf9683573a09c4"
SRC_URI[android-tzdata-0.1.1.sha256sum] = "e999941b234f3131b00bc13c22d06e8c5ff726d1b6318ac7eb276997bbb4fef0"
SRC_URI[android_system_properties-0.1.5.sha256sum] = "819e7219dbd41043ac279b19830f2efc897156490d7fd6ea916720117ee66311"
SRC_URI[anstream-0.6.20.sha256sum] = "3ae563653d1938f79b1ab1b5e668c87c76a9930414574a6583a7b7e11a8e6192"
SRC_URI[anstyle-parse-0.2.7.sha256sum] = "4e7644824f0aa2c7b9384579234ef10eb7efb6a0deb83f9630a49594dd9c15c2"
SRC_URI[anstyle-query-1.1.4.sha256sum] = "9e231f6134f61b71076a3eab506c379d4f36122f2af15a9ff04415ea4c3339e2"
SRC_URI[anstyle-wincon-3.0.10.sha256sum] = "3e0633414522a32ffaac8ac6cc8f748e090c5717661fddeea04219e2344f5f2a"
SRC_URI[anstyle-1.0.11.sha256sum] = "862ed96ca487e809f1c8e5a8447f6ee2cf102f846893800b20cebdf541fc6bbd"
SRC_URI[anyhow-1.0.99.sha256sum] = "b0674a1ddeecb70197781e945de4b3b8ffb61fa939a5597bcf48503737663100"
SRC_URI[arrayvec-0.7.6.sha256sum] = "7c02d123df017efcdfbd739ef81735b36c5ba83ec3c59c80a9d7ecc718f92e50"
SRC_URI[async-broadcast-0.7.2.sha256sum] = "435a87a52755b8f27fcf321ac4f04b2802e337c8c4872923137471ec39c37532"
SRC_URI[async-recursion-1.1.1.sha256sum] = "3b43422f69d8ff38f95f1b2bb76517c91589a924d1559a0e935d7c8ce0274c11"
SRC_URI[async-trait-0.1.89.sha256sum] = "9035ad2d096bed7955a320ee7e2230574d28fd3c3a0f186cbea1ff3c7eed5dbb"
SRC_URI[atomic-waker-1.1.2.sha256sum] = "1505bd5d3d116872e7271a6d4e16d81d0c8570876c8de68093a09ac269d8aac0"
SRC_URI[atomic_refcell-0.1.13.sha256sum] = "41e67cd8309bbd06cd603a9e693a784ac2e5d1e955f11286e355089fcab3047c"
SRC_URI[autocfg-1.5.0.sha256sum] = "c08606f8c3cbf4ce6ec8e28fb0014a2c086708fe954eaa885384a6165172e7e8"
SRC_URI[backtrace-0.3.75.sha256sum] = "6806a6321ec58106fea15becdad98371e28d92ccbc7c8f1b3b6dd724fe8f1002"
SRC_URI[base64-0.22.1.sha256sum] = "72b3254f16251a8381aa12e40e3c4d2f0199f8c6508fbecb9d91f575e0fbb8c6"
SRC_URI[base64ct-1.7.3.sha256sum] = "89e25b6adfb930f02d1981565a6e5d9c547ac15a96606256d3b59040e5cd4ca3"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bitflags-2.9.3.sha256sum] = "34efbcccd345379ca2868b2b2c9d3782e9cc58ba87bc7d79d5b53d9c9ae6f25d"
SRC_URI[block-buffer-0.10.4.sha256sum] = "3078c7629b62d3f0439517fa394996acacc5cbc91c5a20d8c658e77abd503a71"
SRC_URI[bumpalo-3.19.0.sha256sum] = "46c5e41b57b8bba42a04676d81cb89e9ee8e859a1a66f80a5a72e1cb76b34d43"
SRC_URI[bytemuck-1.23.2.sha256sum] = "3995eaeebcdf32f91f980d360f78732ddc061097ab4e39991ae7a6ace9194677"
SRC_URI[byteorder-1.5.0.sha256sum] = "1fd0f2584146f6f2ef48085050886acf353beff7305ebd1ae69500e27c67f64b"
SRC_URI[bytes-1.10.1.sha256sum] = "d71b6127be86fdcfddb610f7182ac57211d4b18a3e9c82eb2d17662f2227ad6a"
SRC_URI[cc-1.2.34.sha256sum] = "42bc4aea80032b7bf409b0bc7ccad88853858911b7713a8062fdc0623867bedc"
SRC_URI[cesu8-1.1.0.sha256sum] = "6d43a04d8753f35258c91f8ec639f792891f748a1edbd759cf1dcea3382ad83c"
SRC_URI[cfg-expr-0.18.0.sha256sum] = "1a2b34126159980f92da2a08bdec0694fd80fb5eb9e48aff25d20a0d8dfa710d"
SRC_URI[cfg-if-1.0.3.sha256sum] = "2fd1289c04a9ea8cb22300a459a72a385d7c73d3259e2ed7dcb2af674838cfa9"
SRC_URI[cfg_aliases-0.2.1.sha256sum] = "613afe47fcd5fac7ccf1db93babcb082c5994d996f20b8b159f2ad1658eb5724"
SRC_URI[chrono-0.4.41.sha256sum] = "c469d952047f47f91b68d1cba3f10d63c11d73e4636f24f08daf0278abf01c4d"
SRC_URI[cipher-0.4.4.sha256sum] = "773f3b9af64447d2ce9850330c473515014aa235e6a783b02db81ff39e4a3dad"
SRC_URI[colorchoice-1.0.4.sha256sum] = "b05b61dc5112cbb17e4b6cd61790d9845d13888356391624cbe7e41efeac1e75"
SRC_URI[combine-4.6.7.sha256sum] = "ba5a308b75df32fe02788e748662718f03fde005016435c444eea572398219fd"
SRC_URI[concurrent-queue-2.5.0.sha256sum] = "4ca0197aee26d1ae37445ee532fefce43251d24cc7c166799f4d46817f1d3973"
SRC_URI[const-oid-0.9.6.sha256sum] = "c2459377285ad874054d797f3ccebf984978aa39129f6eafde5cdc8315b612f8"
SRC_URI[core-foundation-sys-0.8.7.sha256sum] = "773648b94d0e5d620f64f280777445740e61fe701025087ec8b57f45c791888b"
SRC_URI[core-foundation-0.10.1.sha256sum] = "b2a6cd9ae233e7f62ba4e9353e81a88df7fc8a5987b8d445b4d90c879bd156f6"
SRC_URI[core-foundation-0.9.4.sha256sum] = "91e195e091a93c46f7102ec7818a2aa394e1e1771c3ab4825963fa03e45afb8f"
SRC_URI[coreaudio-rs-0.13.0.sha256sum] = "1aae284fbaf7d27aa0e292f7677dfbe26503b0d555026f702940805a630eac17"
SRC_URI[cpal-0.16.0.sha256sum] = "cbd307f43cc2a697e2d1f8bc7a1d824b5269e052209e28883e5bc04d095aaa3f"
SRC_URI[cpufeatures-0.2.17.sha256sum] = "59ed5838eebb26a2bb2e58f6d5b5316989ae9d08bab10e0e6d103e656d1b0280"
SRC_URI[crc32fast-1.5.0.sha256sum] = "9481c1c90cbf2ac953f07c8d4a58aa3945c425b7185c9154d67a65e4230da511"
SRC_URI[crossbeam-utils-0.8.21.sha256sum] = "d0a5c400df2834b80a4c3327b3aad3a4c4cd4de0629063962b03235697506a28"
SRC_URI[crypto-common-0.1.6.sha256sum] = "1bfb12502f3fc46cca1bb51ac28df9d618d813cdc3d2f25b9fe775a34af26bb3"
SRC_URI[ctr-0.9.2.sha256sum] = "0369ee1ad671834580515889b80f2ea915f23b8be8d0daa4bbaf2ac5c7590835"
SRC_URI[darling-0.20.11.sha256sum] = "fc7f46116c46ff9ab3eb1597a45688b6715c6e628b5c133e288e709a29bcb4ee"
SRC_URI[darling_core-0.20.11.sha256sum] = "0d00b9596d185e565c2207a0b01f8bd1a135483d02d9b7b0a54b11da8d53412e"
SRC_URI[darling_macro-0.20.11.sha256sum] = "fc34b93ccb385b40dc71c6fceac4b2ad23662c7eeb248cf10d529b7e055b6ead"
SRC_URI[dasp_sample-0.11.0.sha256sum] = "0c87e182de0887fd5361989c677c4e8f5000cd9491d6d563161a8f3a5519fc7f"
SRC_URI[data-encoding-2.9.0.sha256sum] = "2a2330da5de22e8a3cb63252ce2abb30116bf5265e89c0e01bc17015ce30a476"
SRC_URI[der-0.7.10.sha256sum] = "e7c1832837b905bbfb5101e07cc24c8deddf52f93225eee6ead5f4d63d53ddcb"
SRC_URI[deranged-0.4.0.sha256sum] = "9c9e6a11ca8224451684bc0d7d5a7adbf8f2fd6887261a1cfc3c0432f9d4068e"
SRC_URI[derive_builder-0.20.2.sha256sum] = "507dfb09ea8b7fa618fcf76e953f4f5e192547945816d5358edffe39f6f94947"
SRC_URI[derive_builder_core-0.20.2.sha256sum] = "2d5bcf7b024d6835cfb3d473887cd966994907effbe9227e8c8219824d06c4e8"
SRC_URI[derive_builder_macro-0.20.2.sha256sum] = "ab63b0e2bf4d5928aff72e83a7dace85d7bba5fe12dcc3c5a572d78caffd3f3c"
SRC_URI[digest-0.10.7.sha256sum] = "9ed9a281f7bc9b7576e61468ba615a66a5c8cfdff42420a70aa82701a3b1e292"
SRC_URI[dispatch2-0.3.0.sha256sum] = "89a09f22a6c6069a18470eb92d2298acf25463f14256d24778e1230d789a2aec"
SRC_URI[displaydoc-0.2.5.sha256sum] = "97369cbbc041bc366949bc74d34658d6cda5621039731c6310521892a3a20ae0"
SRC_URI[dns-sd-0.1.3.sha256sum] = "d748509dea20228f63ba519bf142ce2593396386125b01f5b0d6412dab972087"
SRC_URI[either-1.15.0.sha256sum] = "48c757948c5ede0e46177b7add2e67155f70e33c07fea8284df6576da70b3719"
SRC_URI[encoding_rs-0.8.35.sha256sum] = "75030f3c4f45dafd7586dd6780965a8c7e8e285a5ecb86713e63a79c5b2766f3"
SRC_URI[endi-1.1.0.sha256sum] = "a3d8a32ae18130a3c84dd492d4215c3d913c3b07c6b63c2eb3eb7ff1101ab7bf"
SRC_URI[enumflags2-0.7.12.sha256sum] = "1027f7680c853e056ebcec683615fb6fbbc07dbaa13b4d5d9442b146ded4ecef"
SRC_URI[enumflags2_derive-0.7.12.sha256sum] = "67c78a4d8fdf9953a5c9d458f9efe940fd97a0cab0941c075a813ac594733827"
SRC_URI[env_filter-0.1.3.sha256sum] = "186e05a59d4c50738528153b83b0b0194d3a29507dfec16eccd4b342903397d0"
SRC_URI[env_logger-0.11.8.sha256sum] = "13c863f0904021b108aa8b2f55046443e6b1ebde8fd4a15c399893aae4fa069f"
SRC_URI[equivalent-1.0.2.sha256sum] = "877a4ace8713b0bcf2a4e7eec82529c029f1d0619886d18145fea96c3ffe5c0f"
SRC_URI[errno-0.3.13.sha256sum] = "778e2ac28f6c47af28e4907f13ffd1e1ddbd400980a9abd7c8df189bf578a5ad"
SRC_URI[event-listener-strategy-0.5.4.sha256sum] = "8be9f3dfaaffdae2972880079a491a1a8bb7cbed0b8dd7a347f668b4150a3b93"
SRC_URI[event-listener-5.4.1.sha256sum] = "e13b66accf52311f30a0db42147dadea9850cb48cd070028831ae5f5d4b856ab"
SRC_URI[fastrand-2.3.0.sha256sum] = "37909eebbb50d72f9059c3b6d82c0463f2ff062c9e95845c43a6c9c0355411be"
SRC_URI[fixedbitset-0.4.2.sha256sum] = "0ce7134b9999ecaf8bcd65542e436736ef32ddca1b3e06094cb6ec5755203b80"
SRC_URI[flate2-1.1.2.sha256sum] = "4a3d7db9596fecd151c5f638c0ee5d5bd487b6e0ea232e5dc96d5250f6f94b1d"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[foldhash-0.1.5.sha256sum] = "d9c4f5dac5e15c24eb999c26181a6ca40b39fe946cbe4c263c7209467bc83af2"
SRC_URI[foreign-types-shared-0.1.1.sha256sum] = "00b0228411908ca8685dba7fc2cdd70ec9990a6e753e89b6ac91a84c40fbaf4b"
SRC_URI[foreign-types-0.3.2.sha256sum] = "f6f339eb8adc052cd2ca78910fda869aefa38d22d5cb648e6485e4d3fc06f3b1"
SRC_URI[form_urlencoded-1.2.2.sha256sum] = "cb4cb245038516f5f85277875cdaa4f7d2c9a0fa0468de06ed190163b1581fcf"
SRC_URI[futures-channel-0.3.31.sha256sum] = "2dff15bf788c671c1934e366d07e30c1814a8ef514e1af724a602e8a2fbe1b10"
SRC_URI[futures-core-0.3.31.sha256sum] = "05f29059c0c2090612e8d742178b0580d2dc940c837851ad723096f87af6663e"
SRC_URI[futures-executor-0.3.31.sha256sum] = "1e28d1d997f585e54aebc3f97d39e72338912123a67330d723fdbb564d646c9f"
SRC_URI[futures-io-0.3.31.sha256sum] = "9e5c1b78ca4aae1ac06c48a526a655760685149f0d465d21f37abfe57ce075c6"
SRC_URI[futures-lite-2.6.1.sha256sum] = "f78e10609fe0e0b3f4157ffab1876319b5b0db102a2c60dc4626306dc46b44ad"
SRC_URI[futures-macro-0.3.31.sha256sum] = "162ee34ebcb7c64a8abebc059ce0fee27c2262618d7b60ed8faf72fef13c3650"
SRC_URI[futures-sink-0.3.31.sha256sum] = "e575fab7d1e0dcb8d0c7bcf9a63ee213816ab51902e6d244a95819acacf1d4f7"
SRC_URI[futures-task-0.3.31.sha256sum] = "f90f7dce0722e95104fcb095585910c0977252f286e354b5e3bd38902cd99988"
SRC_URI[futures-timer-3.0.3.sha256sum] = "f288b0a4f20f9a56b5d1da57e2227c661b7b16168e2f72365f57b63326e29b24"
SRC_URI[futures-util-0.3.31.sha256sum] = "9fa08315bb612088cc391249efdc3bc77536f16c91f6cf495e6fbe85b20a4a81"
SRC_URI[futures-0.3.31.sha256sum] = "65bc07b1a8bc7c85c5f2e110c476c7389b4554ba72af57d8445ea63a576b0876"
SRC_URI[generic-array-0.14.7.sha256sum] = "85649ca51fd72272d7821adaf274ad91c288277713d9c18820d8499a7ff69e9a"
SRC_URI[getopts-0.2.23.sha256sum] = "cba6ae63eb948698e300f645f87c70f76630d505f23b8907cf1e193ee85048c1"
SRC_URI[getrandom-0.2.16.sha256sum] = "335ff9f135e4384c8150d6f27c6daed433577f86b4750418338c01a1a2528592"
SRC_URI[getrandom-0.3.3.sha256sum] = "26145e563e54f2cadc477553f1ec5ee650b00862f0a58bcd12cbdc5f0ea2d2f4"
SRC_URI[gimli-0.31.1.sha256sum] = "07e28edb80900c19c28f1072f2e8aeca7fa06b23cd4169cefe1af5aa3260783f"
SRC_URI[gio-sys-0.21.1.sha256sum] = "a03f2234671e5a588cfe1f59c2b22c103f5772ea351be9cc824a9ce0d06d99fd"
SRC_URI[glib-macros-0.21.0.sha256sum] = "e772291ebea14c28eb11bb75741f62f4a4894f25e60ce80100797b6b010ef0f9"
SRC_URI[glib-sys-0.21.1.sha256sum] = "dc7c43cff6a7dc43821e45ebf172399437acd6716fa2186b6852d2b397bf622d"
SRC_URI[glib-0.21.1.sha256sum] = "60bdc26493257b5794ba9301f7cbaf7ab0d69a570bfbefa4d7d360e781cb5205"
SRC_URI[gobject-sys-0.21.1.sha256sum] = "3e9a190eef2bce144a6aa8434e306974c6062c398e0a33a146d60238f9062d5c"
SRC_URI[governor-0.10.1.sha256sum] = "444405bbb1a762387aa22dd569429533b54a1d8759d35d3b64cb39b0293eaa19"
SRC_URI[gstreamer-app-sys-0.24.0.sha256sum] = "aaf1a3af017f9493c34ccc8439cbce5c48f6ddff6ec0514c23996b374ff25f9a"
SRC_URI[gstreamer-app-0.24.0.sha256sum] = "fad8ae64a7af6d1aa04e96db085a0cbd64a6b838d85c115c99fa053ab8902d98"
SRC_URI[gstreamer-audio-sys-0.24.0.sha256sum] = "626cd3130bc155a8b6d4ac48cfddc15774b5a6cc76fcb191aab09a2655bad8f5"
SRC_URI[gstreamer-audio-0.24.0.sha256sum] = "7404c5d0cbb2189e6a10d05801e93f47fe60b195e4d73dd1c540d055f7b340b8"
SRC_URI[gstreamer-base-sys-0.24.0.sha256sum] = "dfad00fa63ddd8132306feef9d5095a3636192f09d925adfd0a9be0d82b9ea91"
SRC_URI[gstreamer-base-0.24.0.sha256sum] = "34745d3726a080e0d57e402a314e37073d0b341f3a5754258550311ca45e4754"
SRC_URI[gstreamer-sys-0.24.0.sha256sum] = "36f46b35f9dc4b5a0dca3f19d2118bb5355c3112f228a99a84ed555f48ce5cf9"
SRC_URI[gstreamer-0.24.1.sha256sum] = "32f5db514ad5ccf70ad35485058aa8b894bb81cfcf76bb994af135d9789427c6"
SRC_URI[h2-0.4.12.sha256sum] = "f3c0b69cfcb4e1b9f1bf2f53f95f766e4661169728ec61cd3fe5a0166f2d1386"
SRC_URI[hashbrown-0.15.5.sha256sum] = "9229cfe53dfd69f0609a49f65461bd93001ea1ef889cd5529dd176593f5338a1"
SRC_URI[headers-core-0.3.0.sha256sum] = "54b4a22553d4242c49fddb9ba998a99962b5cc6f22cb5a3482bec22522403ce4"
SRC_URI[headers-0.4.1.sha256sum] = "b3314d5adb5d94bcdf56771f2e50dbbc80bb4bdf88967526706205ac9eff24eb"
SRC_URI[heck-0.5.0.sha256sum] = "2304e00983f87ffb38b55b444b5e3b60a884b5d30c0fca7d82fe33449bbe55ea"
SRC_URI[hex-0.4.3.sha256sum] = "7f24254aa9a54b5c858eaee2f5bccdb46aaf0e486a595ed5fd8f86ba55232a70"
SRC_URI[hmac-0.12.1.sha256sum] = "6c49c37c09c17a53d937dfbb742eb3a961d65a994e6bcdcf37e7399d0cc8ab5e"
SRC_URI[home-0.5.11.sha256sum] = "589533453244b0995c858700322199b2becb13b627df2851f64a2775d024abcf"
SRC_URI[hostname-0.4.1.sha256sum] = "a56f203cd1c76362b69e3863fd987520ac36cf70a8c92627449b2f64a8cf7d65"
SRC_URI[http-body-util-0.1.3.sha256sum] = "b021d93e26becf5dc7e1b75b1bed1fd93124b374ceb73f43d4d4eafec896a64a"
SRC_URI[http-body-1.0.1.sha256sum] = "1efedce1fb8e6913f23e0c92de8e62cd5b772a67e7b3946df930a62566c93184"
SRC_URI[http-1.3.1.sha256sum] = "f4a85d31aea989eead29a3aaf9e1115a180df8282431156e533de47660892565"
SRC_URI[httparse-1.10.1.sha256sum] = "6dbf3de79e51f3d586ab4cb9d5c3e2c14aa28ed23d180cf89b4df0454a69cc87"
SRC_URI[httpdate-1.0.3.sha256sum] = "df3b46402a9d5adb4c86a0cf463f42e19994e3ee891101b1841f30a545cb49a9"
SRC_URI[hyper-proxy2-0.1.0.sha256sum] = "9043b7b23fb0bc4a1c7014c27b50a4fc42cc76206f71d34fc0dfe5b28ddc3faf"
SRC_URI[hyper-rustls-0.26.0.sha256sum] = "a0bea761b46ae2b24eb4aef630d8d1c398157b6fc29e6350ecf090a0b70c952c"
SRC_URI[hyper-rustls-0.27.7.sha256sum] = "e3c93eb611681b207e1fe55d5a71ecf91572ec8a6705cdb6857f7d8d5242cf58"
SRC_URI[hyper-tls-0.6.0.sha256sum] = "70206fc6890eaca9fde8a0bf71caa2ddfc9fe045ac9e5c70df101a7dbde866e0"
SRC_URI[hyper-util-0.1.16.sha256sum] = "8d9b05277c7e8da2c93a568989bb6207bef0112e8d17df7a6eda4a3cf143bc5e"
SRC_URI[hyper-1.7.0.sha256sum] = "eb3aa54a13a0dfe7fbe3a59e0c76093041720fdc77b110cc0fc260fafb4dc51e"
SRC_URI[iana-time-zone-haiku-0.1.2.sha256sum] = "f31827a206f56af32e590ba56d5d2d085f558508192593743f16b2306495269f"
SRC_URI[iana-time-zone-0.1.63.sha256sum] = "b0c919e5debc312ad217002b8048a17b7d83f80703865bbfcfebb0458b0b27d8"
SRC_URI[icu_collections-2.0.0.sha256sum] = "200072f5d0e3614556f94a9930d5dc3e0662a652823904c3a75dc3b0af7fee47"
SRC_URI[icu_locale_core-2.0.0.sha256sum] = "0cde2700ccaed3872079a65fb1a78f6c0a36c91570f28755dda67bc8f7d9f00a"
SRC_URI[icu_normalizer-2.0.0.sha256sum] = "436880e8e18df4d7bbc06d58432329d6458cc84531f7ac5f024e93deadb37979"
SRC_URI[icu_normalizer_data-2.0.0.sha256sum] = "00210d6893afc98edb752b664b8890f0ef174c8adbb8d0be9710fa66fbbf72d3"
SRC_URI[icu_properties-2.0.1.sha256sum] = "016c619c1eeb94efb86809b015c58f479963de65bdb6253345c1a1276f22e32b"
SRC_URI[icu_properties_data-2.0.1.sha256sum] = "298459143998310acd25ffe6810ed544932242d3f07083eee1084d83a71bd632"
SRC_URI[icu_provider-2.0.0.sha256sum] = "03c80da27b5f4187909049ee2d72f276f0d9f99a42c306bd0131ecfe04d8e5af"
SRC_URI[ident_case-1.0.1.sha256sum] = "b9e0384b61958566e926dc50660321d12159025e767c18e043daf26b70104c39"
SRC_URI[idna-1.1.0.sha256sum] = "3b0875f23caa03898994f6ddc501886a45c7d3d62d04d2d90788d47be1b1e4de"
SRC_URI[idna_adapter-1.2.1.sha256sum] = "3acae9609540aa318d1bc588455225fb2085b9ed0c4f6bd0d9d5bcd86f1a0344"
SRC_URI[if-addrs-0.12.0.sha256sum] = "bb2a33e9c38988ecbda730c85b0fd9ddcdf83c0305ac7fd21c8bb9f57f2f0cc8"
SRC_URI[indexmap-2.11.0.sha256sum] = "f2481980430f9f78649238835720ddccc57e52df14ffce1c6f37391d61b563e9"
SRC_URI[inout-0.1.4.sha256sum] = "879f10e63c20629ecabbb64a8010319738c66a5cd0c29b02d63d272b03751d01"
SRC_URI[io-uring-0.7.10.sha256sum] = "046fa2d4d00aea763528b4950358d0ead425372445dc8ff86312b3c69ff7727b"
SRC_URI[ipnet-2.11.0.sha256sum] = "469fb0b9cefa57e3ef31275ee7cacb78f2fdca44e4765491884a2b119d4eb130"
SRC_URI[iri-string-0.7.8.sha256sum] = "dbc5ebe9c3a1a7a5127f920a418f7585e9e758e911d0466ed004f393b0e380b2"
SRC_URI[is-docker-0.2.0.sha256sum] = "928bae27f42bc99b60d9ac7334e3a21d10ad8f1835a4e12ec3ec0464765ed1b3"
SRC_URI[is-wsl-0.4.0.sha256sum] = "173609498df190136aa7dea1a91db051746d339e18476eed5ca40521f02d7aa5"
SRC_URI[is_terminal_polyfill-1.70.1.sha256sum] = "7943c866cc5cd64cbc25b2e01621d07fa8eb2a1a23160ee81ce38704e97b8ecf"
SRC_URI[itertools-0.14.0.sha256sum] = "2b192c782037fadd9cfa75548310488aabdbf3d2da73885b31bd0abd03351285"
SRC_URI[itoa-1.0.15.sha256sum] = "4a5f13b858c8d314ee3e8f639011f7ccefe71f97f96e50151fb991f267928e2c"
SRC_URI[jack-sys-0.5.1.sha256sum] = "6013b7619b95a22b576dfb43296faa4ecbe40abbdb97dfd22ead520775fc86ab"
SRC_URI[jack-0.13.3.sha256sum] = "f70ca699f44c04a32d419fc9ed699aaea89657fc09014bf3fa238e91d13041b9"
SRC_URI[jiff-static-0.2.15.sha256sum] = "03343451ff899767262ec32146f6d559dd759fdadf42ff0e227c7c48f72594b4"
SRC_URI[jiff-0.2.15.sha256sum] = "be1f93b8b1eb69c77f24bbb0afdf66f54b632ee39af40ca21c4365a1d7347e49"
SRC_URI[jni-sys-0.3.0.sha256sum] = "8eaf4bc02d17cbdd7ff4c7438cafcdf7fb9a4613313ad11b4f8fefe7d3fa0130"
SRC_URI[jni-0.21.1.sha256sum] = "1a87aa2bb7d2af34197c04845522473242e1aa17c12f4935d5856491a7fb8c97"
SRC_URI[js-sys-0.3.77.sha256sum] = "1cfaf33c695fc6e08064efbc1f72ec937429614f25eef83af942d0e227c3a28f"
SRC_URI[kstring-2.0.2.sha256sum] = "558bf9508a558512042d3095138b1f7b8fe90c5467d94f9f1da28b3731c5dbd1"
SRC_URI[lazy_static-1.5.0.sha256sum] = "bbd2bcb4c963f2ddae06a2efc7e9f3591312473c50c6685e1f298068316e66fe"
SRC_URI[libc-0.2.175.sha256sum] = "6a82ae493e598baaea5209805c49bbf2ea7de956d50d7da0da1164f9c6d28543"
SRC_URI[libloading-0.7.4.sha256sum] = "b67380fd3b2fbe7527a606e18729d21c6f3951633d0500574c4dc22d2d638b9f"
SRC_URI[libm-0.2.15.sha256sum] = "f9fbbcab51052fe104eb5e5d351cf728d30a5be1fe14d9be8a3b097481fb97de"
SRC_URI[libmdns-0.9.1.sha256sum] = "48854699e11b111433431b69cee2365fcab0b29b06993f48c257dfbaf6395862"
SRC_URI[libpulse-binding-2.30.1.sha256sum] = "909eb3049e16e373680fe65afe6e2a722ace06b671250cc4849557bc57d6a397"
SRC_URI[libpulse-simple-binding-2.29.0.sha256sum] = "b7bebef0381c8e3e4b23cc24aaf36fab37472bece128de96f6a111efa464cfef"
SRC_URI[libpulse-simple-sys-1.22.0.sha256sum] = "3bd96888fe37ad270d16abf5e82cccca1424871cf6afa2861824d2a52758eebc"
SRC_URI[libpulse-sys-1.23.0.sha256sum] = "d74371848b22e989f829cc1621d2ebd74960711557d8b45cfe740f60d0a05e61"
SRC_URI[linux-raw-sys-0.4.15.sha256sum] = "d26c52dbd32dccf2d10cac7725f8eae5296885fb5703b261f7d0a0739ec807ab"
SRC_URI[linux-raw-sys-0.9.4.sha256sum] = "cd945864f07fe9f5371a27ad7b52a172b4b499999f1d97574c9fa68373937e12"
SRC_URI[litemap-0.8.0.sha256sum] = "241eaef5fd12c88705a01fc1066c48c4b36e0dd4377dcdc7ec3942cea7a69956"
SRC_URI[lock_api-0.4.13.sha256sum] = "96936507f153605bddfcda068dd804796c84324ed2510809e5b2a624c81da765"
SRC_URI[log-0.4.27.sha256sum] = "13dc2df351e3202783a1fe0d44375f7295ffb4049267b0f3018346dc122a1d94"
SRC_URI[lru-slab-0.1.2.sha256sum] = "112b39cec0b298b6c1999fee3e31427f74f676e4cb9879ed1a121b43661a4154"
SRC_URI[mach2-0.4.3.sha256sum] = "d640282b302c0bb0a2a8e0233ead9035e3bed871f0b7e81fe4a1ec829765db44"
SRC_URI[memchr-2.7.5.sha256sum] = "32a282da65faaf38286cf3be983213fcf1d2e2a58700e808f83f4ea9a4804bc0"
SRC_URI[memoffset-0.9.1.sha256sum] = "488016bfae457b036d996092f6cb448677611ce4449e970ceaf42695203f218a"
SRC_URI[mime-0.3.17.sha256sum] = "6877bb514081ee2a7ff5ef9de3281f14a4dd4bceac4c09388074a6b5df8a139a"
SRC_URI[miniz_oxide-0.8.9.sha256sum] = "1fa76a2c86f704bdb222d66965fb3d63269ce38518b83cb0575fca855ebb6316"
SRC_URI[mio-1.0.4.sha256sum] = "78bed444cc8a2160f01cbcf811ef18cac863ad68ae8ca62092e8db51d51c761c"
SRC_URI[muldiv-1.0.1.sha256sum] = "956787520e75e9bd233246045d19f42fb73242759cc57fba9611d940ae96d4b0"
SRC_URI[multimap-0.10.1.sha256sum] = "1d87ecb2933e8aeadb3e3a02b828fed80a7528047e68b4f424523a0981a3a084"
SRC_URI[native-tls-0.2.14.sha256sum] = "87de3442987e9dbec73158d5c715e7ad9072fda936bb03d19d7fa10e00520f0e"
SRC_URI[ndk-context-0.1.1.sha256sum] = "27b02d87554356db9e9a873add8782d4ea6e3e58ea071a9adb9a2e8ddb884a8b"
SRC_URI[ndk-sys-0.6.0+11769913.sha256sum] = "ee6cda3051665f1fb8d9e08fc35c96d5a244fb1be711a03b71118828afc9a873"
SRC_URI[ndk-0.9.0.sha256sum] = "c3f42e7bbe13d351b6bead8286a43aac9534b82bd3cc43e47037f012ebfd62d4"
SRC_URI[nix-0.30.1.sha256sum] = "74523f3a35e05aba87a1d978330aef40f67b0304ac79c1c00b294c9830543db6"
SRC_URI[nonzero_ext-0.3.0.sha256sum] = "38bf9645c8b145698bb0b18a4637dcacbc421ea49bef2317e4fd8065a387cf21"
SRC_URI[ntapi-0.4.1.sha256sum] = "e8a3895c6391c39d7fe7ebc444a87eb2991b2a0bc718fdabd071eec617fc68e4"
SRC_URI[num-bigint-dig-0.8.4.sha256sum] = "dc84195820f291c7697304f3cbdadd1cb7199c0efc917ff5eafd71225c136151"
SRC_URI[num-bigint-0.4.6.sha256sum] = "a5e44f723f1133c9deac646763579fdb3ac745e418f2a7af9cd0c431da1f20b9"
SRC_URI[num-conv-0.1.0.sha256sum] = "51d515d32fb182ee37cda2ccdcb92950d6a3c2893aa280e540671c2cd0f3b1d9"
SRC_URI[num-derive-0.4.2.sha256sum] = "ed3955f1a9c7c0c15e092f9c887db08b1fc683305fdf6eb6684f22555355e202"
SRC_URI[num-integer-0.1.46.sha256sum] = "7969661fd2958a5cb096e56c8e1ad0444ac2bbcd0061bd28660485a44879858f"
SRC_URI[num-iter-0.1.45.sha256sum] = "1429034a0490724d0075ebb2bc9e875d6503c3cf69e235a8941aa757d83ef5bf"
SRC_URI[num-rational-0.4.2.sha256sum] = "f83d14da390562dca69fc84082e73e548e1ad308d24accdedd2720017cb37824"
SRC_URI[num-traits-0.2.19.sha256sum] = "071dfc062690e90b734c0b2273ce72ad0ffa95f0c74596bc250dcfd960262841"
SRC_URI[num_enum-0.7.4.sha256sum] = "a973b4e44ce6cad84ce69d797acf9a044532e4184c4f267913d1b546a0727b7a"
SRC_URI[num_enum_derive-0.7.4.sha256sum] = "77e878c846a8abae00dd069496dbe8751b16ac1c3d6bd2a7283a938e8228f90d"
SRC_URI[num_threads-0.1.7.sha256sum] = "5c7398b9c8b70908f6371f47ed36737907c87c52af34c268fed0bf0ceb92ead9"
SRC_URI[oauth2-5.0.0.sha256sum] = "51e219e79014df21a225b1860a479e2dcd7cbd9130f4defd4bd0e191ea31d67d"
SRC_URI[objc2-audio-toolbox-0.3.1.sha256sum] = "10cbe18d879e20a4aea544f8befe38bcf52255eb63d3f23eca2842f3319e4c07"
SRC_URI[objc2-core-audio-types-0.3.1.sha256sum] = "c0f1cc99bb07ad2ddb6527ddf83db6a15271bb036b3eb94b801cd44fdc666ee1"
SRC_URI[objc2-core-audio-0.3.1.sha256sum] = "ca44961e888e19313b808f23497073e3f6b3c22bb485056674c8b49f3b025c82"
SRC_URI[objc2-core-foundation-0.3.1.sha256sum] = "1c10c2894a6fed806ade6027bcd50662746363a9589d3ec9d9bef30a4e4bc166"
SRC_URI[objc2-encode-4.1.0.sha256sum] = "ef25abbcd74fb2609453eb695bd2f860d389e457f67dc17cafc8b8cbc89d0c33"
SRC_URI[objc2-foundation-0.3.1.sha256sum] = "900831247d2fe1a09a683278e5384cfb8c80c79fe6b166f9d14bfdde0ea1b03c"
SRC_URI[objc2-io-kit-0.3.1.sha256sum] = "71c1c64d6120e51cd86033f67176b1cb66780c2efe34dec55176f77befd93c0a"
SRC_URI[objc2-0.6.2.sha256sum] = "561f357ba7f3a2a61563a186a163d0a3a5247e1089524a3981d49adb775078bc"
SRC_URI[object-0.36.7.sha256sum] = "62948e14d923ea95ea2c7c86c71013138b66525b86bdc08d2dcc262bdb497b87"
SRC_URI[ogg-0.9.2.sha256sum] = "fdab8dcd8d4052eaacaf8fb07a3ccd9a6e26efadb42878a413c68fc4af1dee2b"
SRC_URI[once_cell-1.21.3.sha256sum] = "42f5e15c9953c5e4ccceeb2e7382a716482c34515315f7b03532b8b4e8393d2d"
SRC_URI[once_cell_polyfill-1.70.1.sha256sum] = "a4895175b425cb1f87721b59f0f286c2092bd4af812243672510e1ac53e2e0ad"
SRC_URI[open-5.3.2.sha256sum] = "e2483562e62ea94312f3576a7aca397306df7990b8d89033e18766744377ef95"
SRC_URI[openssl-macros-0.1.1.sha256sum] = "a948666b637a0f465e8564c73e89d4dde00d72d4d473cc972f390fc3dcee7d9c"
SRC_URI[openssl-probe-0.1.6.sha256sum] = "d05e27ee213611ffe7d6348b942e8f942b37114c00cc03cec254295a4a17852e"
SRC_URI[openssl-sys-0.9.109.sha256sum] = "90096e2e47630d78b7d1c20952dc621f957103f8bc2c8359ec81290d75238571"
SRC_URI[openssl-0.10.73.sha256sum] = "8505734d46c8ab1e19a1dce3aef597ad87dcb4c37e7188231769bd6bd51cebf8"
SRC_URI[option-operations-0.5.0.sha256sum] = "7c26d27bb1aeab65138e4bf7666045169d1717febcc9ff870166be8348b223d0"
SRC_URI[ordered-stream-0.2.0.sha256sum] = "9aa2b01e1d916879f73a53d01d1d6cee68adbb31d6d9177a8cfce093cced1d50"
SRC_URI[parking-2.2.1.sha256sum] = "f38d5652c16fde515bb1ecef450ab0f6a219d619a7274976324d5e377f7dceba"
SRC_URI[parking_lot-0.12.4.sha256sum] = "70d58bf43669b5795d1576d0641cfb6fbb2057bf629506267a92807158584a13"
SRC_URI[parking_lot_core-0.9.11.sha256sum] = "bc838d2a56b5b1a6c25f55575dfc605fabb63bb2365f6c2353ef9159aa69e4a5"
SRC_URI[paste-1.0.15.sha256sum] = "57c0d7b74b563b49d38dae00a0c37d4d6de9b432382b2892f0574ddcae73fd0a"
SRC_URI[pathdiff-0.2.3.sha256sum] = "df94ce210e5bc13cb6651479fa48d14f601d9858cfe0467f43ae157023b938d3"
SRC_URI[pbkdf2-0.12.2.sha256sum] = "f8ed6a7761f76e3b9f92dfb0a60a6a6477c61024b775147ff0973a02653abaf2"
SRC_URI[pem-rfc7468-0.7.0.sha256sum] = "88b39c9bfcfc231068454382784bb460aae594343fb030d46e9f50a645418412"
SRC_URI[percent-encoding-2.3.2.sha256sum] = "9b4f627cb1b25917193a259e49bdad08f671f8d9708acfd5fe0a8c1455d87220"
SRC_URI[petgraph-0.6.5.sha256sum] = "b4c5cc86750666a3ed20bdaf5ca2a0344f9c67674cae0515bec2da16fbaa47db"
SRC_URI[pin-project-lite-0.2.16.sha256sum] = "3b3cff922bd51709b605d9ead9aa71031d81447142d828eb4a6eba76fe619f9b"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[pkcs1-0.7.5.sha256sum] = "c8ffb9f10fa047879315e6625af03c164b16962a5368d724ed16323b68ace47f"
SRC_URI[pkcs8-0.10.2.sha256sum] = "f950b2377845cebe5cf8b5165cb3cc1a5e0fa5cfa3e1f7f55707d8fd82e0a7b7"
SRC_URI[pkg-config-0.3.32.sha256sum] = "7edddbd0b52d732b21ad9a5fab5c704c14cd949e5e9a1ec5929a24fded1b904c"
SRC_URI[portable-atomic-util-0.2.4.sha256sum] = "d8a2f0d8d040d7848a709caf78912debcc3f33ee4b3cac47d73d1e1069e83507"
SRC_URI[portable-atomic-1.11.1.sha256sum] = "f84267b20a16ea918e43c6a88433c2d54fa145c92a811b5b047ccbe153674483"
SRC_URI[portaudio-rs-0.3.2.sha256sum] = "cdb6b5eff96ccc9bf44d34c379ab03ae944426d83d1694345bdf8159d561d562"
SRC_URI[portaudio-sys-0.1.1.sha256sum] = "5194a4fa953b4ffd851c320ef6f0484cd7278cb7169ea9d6c433e49b23f7b7f5"
SRC_URI[potential_utf-0.1.2.sha256sum] = "e5a7c30837279ca13e7c867e9e40053bc68740f988cb07f7ca6df43cc734b585"
SRC_URI[powerfmt-0.2.0.sha256sum] = "439ee305def115ba05938db6eb1644ff94165c5ab5e9420d1c1bcedbba909391"
SRC_URI[ppv-lite86-0.2.21.sha256sum] = "85eae3c4ed2f50dcfe72643da4befc30deadb458a9b590d720cde2f2b1e97da9"
SRC_URI[priority-queue-2.5.0.sha256sum] = "5676d703dda103cbb035b653a9f11448c0a7216c7926bd35fcb5865475d0c970"
SRC_URI[proc-macro-crate-3.3.0.sha256sum] = "edce586971a4dfaa28950c6f18ed55e0406c1ab88bbce2c6f6293a7aaba73d35"
SRC_URI[proc-macro2-1.0.101.sha256sum] = "89ae43fd86e4158d6db51ad8e2b80f313af9cc74f5c0e03ccb87de09998732de"
SRC_URI[protobuf-codegen-3.7.2.sha256sum] = "5d3976825c0014bbd2f3b34f0001876604fe87e0c86cd8fa54251530f1544ace"
SRC_URI[protobuf-json-mapping-3.7.2.sha256sum] = "e0d6e4be637b310d8a5c02fa195243328e2d97fa7df1127a27281ef1187fcb1d"
SRC_URI[protobuf-parse-3.7.2.sha256sum] = "b4aeaa1f2460f1d348eeaeed86aea999ce98c1bded6f089ff8514c9d9dbdc973"
SRC_URI[protobuf-support-3.7.2.sha256sum] = "3e36c2f31e0a47f9280fb347ef5e461ffcd2c52dd520d8e216b52f93b0b0d7d6"
SRC_URI[protobuf-3.7.2.sha256sum] = "d65a1d4ddae7d8b5de68153b48f6aa3bba8cb002b243dbdbc55a5afbc98f99f4"
SRC_URI[quick-xml-0.38.3.sha256sum] = "42a232e7487fc2ef313d96dde7948e7a3c05101870d8985e4fd8d26aedd27b89"
SRC_URI[quinn-proto-0.11.12.sha256sum] = "49df843a9161c85bb8aae55f101bc0bac8bcafd637a620d9122fd7e0b2f7422e"
SRC_URI[quinn-udp-0.5.13.sha256sum] = "fcebb1209ee276352ef14ff8732e24cc2b02bbac986cd74a4c81bcb2f9881970"
SRC_URI[quinn-0.11.8.sha256sum] = "626214629cda6781b6dc1d316ba307189c85ba657213ce642d9c77670f8202c8"
SRC_URI[quote-1.0.40.sha256sum] = "1885c039570dc00dcb4ff087a89e185fd56bae234ddc7f056a945bf36467248d"
SRC_URI[r-efi-5.3.0.sha256sum] = "69cdb34c158ceb288df11e18b4bd39de994f6657d83847bdffdbd7f346754b0f"
SRC_URI[rand-0.8.5.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand-0.9.2.sha256sum] = "6db2770f06117d490610c7488547d543617b21bfa07796d7a12f6f1bd53850d1"
SRC_URI[rand_chacha-0.3.1.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_chacha-0.9.0.sha256sum] = "d3022b5f1df60f26e1ffddd6c66e8aa15de382ae63b3a0c1bfc0e4d3e3f325cb"
SRC_URI[rand_core-0.6.4.sha256sum] = "ec0be4795e2f6a28069bec0b5ff3e2ac9bafc99e6a9a7dc3547996c5c816922c"
SRC_URI[rand_core-0.9.3.sha256sum] = "99d9a13982dcf210057a8a78572b2217b667c3beacbf3a0d8b454f6f82837d38"
SRC_URI[rand_distr-0.5.1.sha256sum] = "6a8615d50dcf34fa31f7ab52692afec947c4dd0ab803cc87cb3b0b4570ff7463"
SRC_URI[redox_syscall-0.5.17.sha256sum] = "5407465600fb0548f1442edf71dd20683c6ed326200ace4b1ef0763521bb3b77"
SRC_URI[regex-automata-0.4.10.sha256sum] = "6b9458fa0bfeeac22b5ca447c63aaf45f28439a709ccd244698632f9aa6394d6"
SRC_URI[regex-syntax-0.8.6.sha256sum] = "caf4aa5b0f434c91fe5c7f1ecb6a5ece2130b02ad2a590589dda5146df959001"
SRC_URI[regex-1.11.2.sha256sum] = "23d7fd106d8c02486a8d64e778353d1cffe08ce79ac2e82f540c86d0facf6912"
SRC_URI[reqwest-0.12.23.sha256sum] = "d429f34c8092b2d42c7c93cec323bb4adeb7c67698f70839adec842ec10c7ceb"
SRC_URI[ring-0.17.14.sha256sum] = "a4689e6c2294d81e88dc6261c768b63bc4fcdb852be6d1352498b114f61383b7"
SRC_URI[rodio-0.21.1.sha256sum] = "e40ecf59e742e03336be6a3d53755e789fd05a059fa22dfa0ed624722319e183"
SRC_URI[rsa-0.9.8.sha256sum] = "78928ac1ed176a5ca1d17e578a1825f3d81ca54cf41053a592584b020cfd691b"
SRC_URI[rustc-demangle-0.1.26.sha256sum] = "56f7d92ca342cea22a06f2121d944b4fd82af56988c270852495420f961d4ace"
SRC_URI[rustc-hash-2.1.1.sha256sum] = "357703d41365b4b27c590e3ed91eabb1b663f07c4c084095e60cbed4362dff0d"
SRC_URI[rustix-0.38.44.sha256sum] = "fdb5bc1ae2baa591800df16c9ca78619bf65c0488b41b96ccec5d11220d8c154"
SRC_URI[rustix-1.0.8.sha256sum] = "11181fbabf243db407ef8df94a6ce0b2f9a733bd8be4ad02b4eda9602296cac8"
SRC_URI[rustls-native-certs-0.7.3.sha256sum] = "e5bfb394eeed242e909609f56089eecfe5fda225042e8b171791b9c95f5931e5"
SRC_URI[rustls-native-certs-0.8.1.sha256sum] = "7fcff2dd52b58a8d98a70243663a0d234c4e2b79235637849d15913394a247d3"
SRC_URI[rustls-pemfile-2.2.0.sha256sum] = "dce314e5fee3f39953d46bb63bb8a46d40c2f8fb7cc5a3b6cab2bde9721d6e50"
SRC_URI[rustls-pki-types-1.12.0.sha256sum] = "229a4a4c221013e7e1f1a043678c5cc39fe5171437c88fb47151a21e6f5b5c79"
SRC_URI[rustls-webpki-0.102.8.sha256sum] = "64ca1bc8749bd4cf37b5ce386cc146580777b4e8572c7b97baf22c83f444bee9"
SRC_URI[rustls-webpki-0.103.4.sha256sum] = "0a17884ae0c1b773f1ccd2bd4a8c72f16da897310a98b0e84bf349ad5ead92fc"
SRC_URI[rustls-0.22.4.sha256sum] = "bf4ef73721ac7bcd79b2b315da7779d8fc09718c6b3d2d1b2d94850eb8c18432"
SRC_URI[rustls-0.23.31.sha256sum] = "c0ebcbd2f03de0fc1122ad9bb24b127a5a6cd51d72604a3f3c50ac459762b6cc"
SRC_URI[rustversion-1.0.22.sha256sum] = "b39cdef0fa800fc44525c84ccb54a029961a8215f9619753635a9c0d2538d46d"
SRC_URI[ryu-1.0.20.sha256sum] = "28d3b2b1366ec20994f1fd18c3c594f05c5dd4bc44d8bb0c1c632c8d6829481f"
SRC_URI[same-file-1.0.6.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[schannel-0.1.27.sha256sum] = "1f29ebaa345f945cec9fbbc532eb307f0fdad8161f281b6369539c8d84876b3d"
SRC_URI[scopeguard-1.2.0.sha256sum] = "94143f37725109f92c262ed2cf5e59bce7498c01bcc1502d7b9afe439a4e9f49"
SRC_URI[sdl2-sys-0.38.0.sha256sum] = "3ff61407fc75d4b0bbc93dc7e4d6c196439965fbef8e4a4f003a36095823eac0"
SRC_URI[sdl2-0.38.0.sha256sum] = "2d42407afc6a8ab67e36f92e80b8ba34cbdc55aaeed05249efe9a2e8d0e9feef"
SRC_URI[security-framework-sys-2.14.0.sha256sum] = "49db231d56a190491cb4aeda9527f1ad45345af50b0851622a7adb8c03b01c32"
SRC_URI[security-framework-2.11.1.sha256sum] = "897b2245f0b511c87893af39b033e5ca9cce68824c4d7e7630b5a1d339658d02"
SRC_URI[security-framework-3.3.0.sha256sum] = "80fb1d92c5028aa318b4b8bd7302a5bfcf48be96a37fc6fc790f806b0004ee0c"
SRC_URI[serde-1.0.219.sha256sum] = "5f0e2c6ed6606019b4e29e69dbaba95b11854410e5347d525002456dbbb786b6"
SRC_URI[serde_derive-1.0.219.sha256sum] = "5b0276cf7f2c73365f7157c8123c21cd9a50fbbd844757af28ca1f5925fc2a00"
SRC_URI[serde_json-1.0.143.sha256sum] = "d401abef1d108fbd9cbaebc3e46611f4b1021f714a0597a71f41ee463f5f4a5a"
SRC_URI[serde_path_to_error-0.1.17.sha256sum] = "59fab13f937fa393d08645bf3a84bdfe86e296747b506ada67bb15f10f218b2a"
SRC_URI[serde_repr-0.1.20.sha256sum] = "175ee3e80ae9982737ca543e96133087cbd9a485eecc3bc4de9c1a37b47ea59c"
SRC_URI[serde_spanned-0.6.9.sha256sum] = "bf41e0cfaf7226dca15e8197172c295a782857fcb97fad1808a166870dee75a3"
SRC_URI[serde_urlencoded-0.7.1.sha256sum] = "d3491c14715ca2294c4d6a88f15e84739788c1d030eed8c110436aafdaa2f3fd"
SRC_URI[sha1-0.10.6.sha256sum] = "e3bf829a2d51ab4a5ddf1352d8470c140cadc8301b2ae1789db023f01cedd6ba"
SRC_URI[sha2-0.10.9.sha256sum] = "a7507d819769d01a365ab707794a4084392c824f54a7a6a7862f8c3d0892b283"
SRC_URI[shannon-0.2.0.sha256sum] = "7ea5b41c9427b56caa7b808cb548a04fb50bb5b9e98590b53f28064ff4174561"
SRC_URI[shell-words-1.1.0.sha256sum] = "24188a676b6ae68c3b2cb3a01be17fbf7240ce009799bb56d5b1409051e78fde"
SRC_URI[shlex-1.3.0.sha256sum] = "0fda2ff0d084019ba4d7c6f371c95d8fd75ce3524c3cb8fb653a3023f6323e64"
SRC_URI[signal-hook-registry-1.4.6.sha256sum] = "b2a4719bff48cee6b39d12c020eeb490953ad2443b7055bd0b21fca26bd8c28b"
SRC_URI[signature-2.2.0.sha256sum] = "77549399552de45a898a580c1b41d445bf730df867cc44e6c0233bbc4b8329de"
SRC_URI[slab-0.4.11.sha256sum] = "7a2ae44ef20feb57a68b23d846850f861394c2e02dc425a50098ae8c90267589"
SRC_URI[smallvec-1.15.1.sha256sum] = "67b1b7a3b5fe4f1376887184045fcf45c69e92af734b7aaddc05fb777b6fbd03"
SRC_URI[socket2-0.5.10.sha256sum] = "e22376abed350d73dd1cd119b57ffccad95b4e585a7cda43e286245ce23c0678"
SRC_URI[socket2-0.6.0.sha256sum] = "233504af464074f9d066d7b5416c5f9b894a5862a6506e306f7b816cdd6f1807"
SRC_URI[spin-0.9.8.sha256sum] = "6980e8d7511241f8acf4aebddbb1ff938df5eebe98691418c4468d0b72a96a67"
SRC_URI[spinning_top-0.3.0.sha256sum] = "d96d2d1d716fb500937168cc09353ffdc7a012be8475ac7308e1bdf0e3923300"
SRC_URI[spki-0.7.3.sha256sum] = "d91ed6c858b01f942cd56b37a94b3e0a1798290327d1236e4d9cf4eaca44d29d"
SRC_URI[stable_deref_trait-1.2.0.sha256sum] = "a8f112729512f8e442d81f95a8a7ddf2b7c6b8a1a6f509a95864142b30cab2d3"
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
SRC_URI[syn-2.0.106.sha256sum] = "ede7c438028d4436d71104916910f5bb611972c5cfd7f89b8300a8186e6fada6"
SRC_URI[sync_wrapper-1.0.2.sha256sum] = "0bf256ce5efdfa370213c1dabab5935a12e49f2c58d15e9eac2870d3b4f27263"
SRC_URI[synstructure-0.13.2.sha256sum] = "728a70f3dbaf5bab7f0c4b1ac8d7ae5ea60a4b5549c8a5914361c99147a709d2"
SRC_URI[sysinfo-0.36.1.sha256sum] = "252800745060e7b9ffb7b2badbd8b31cfa4aa2e61af879d0a3bf2a317c20217d"
SRC_URI[system-configuration-sys-0.6.0.sha256sum] = "8e1d1b10ced5ca923a1fcb8d03e96b8d3268065d724548c0211415ff6ac6bac4"
SRC_URI[system-configuration-0.6.1.sha256sum] = "3c879d448e9d986b661742763247d3693ed13609438cf3d006f51f5368a5ba6b"
SRC_URI[system-deps-7.0.5.sha256sum] = "e4be53aa0cba896d2dc615bd42bbc130acdcffa239e0a2d965ea5b3b2a86ffdb"
SRC_URI[target-lexicon-0.13.2.sha256sum] = "e502f78cdbb8ba4718f566c418c52bc729126ffd16baee5baa718cf25dd5a69a"
SRC_URI[tempfile-3.21.0.sha256sum] = "15b61f8f20e3a6f7e0649d825294eaf317edce30f82cf6026e7e4cb9222a7d1e"
SRC_URI[thiserror-impl-1.0.69.sha256sum] = "4fee6c4efc90059e10f81e6d42c60a18f76588c3d74cb83a0b242a2b6c7504c1"
SRC_URI[thiserror-impl-2.0.16.sha256sum] = "6c5e1be1c48b9172ee610da68fd9cd2770e7a4056cb3fc98710ee6906f0c7960"
SRC_URI[thiserror-1.0.69.sha256sum] = "b6aaf5339b578ea85b50e080feb250a3e8ae8cfcdff9a461c9ec2904bc923f52"
SRC_URI[thiserror-2.0.16.sha256sum] = "3467d614147380f2e4e374161426ff399c91084acd2363eaf549172b3d5e60c0"
SRC_URI[thread-id-4.2.2.sha256sum] = "cfe8f25bbdd100db7e1d34acf7fd2dc59c4bf8f7483f505eaa7d4f12f76cc0ea"
SRC_URI[time-core-0.1.4.sha256sum] = "c9e9a38711f559d9e3ce1cdb06dd7c5b8ea546bc90052da6d06bb76da74bb07c"
SRC_URI[time-macros-0.2.22.sha256sum] = "3526739392ec93fd8b359c8e98514cb3e8e021beb4e5f597b00a0221f8ed8a49"
SRC_URI[time-0.3.41.sha256sum] = "8a7619e19bc266e0f9c5e6686659d394bc57973859340060a69221e57dbc0c40"
SRC_URI[tinystr-0.8.1.sha256sum] = "5d4f6d1145dcb577acf783d4e601bc1d76a13337bb54e6233add580b07344c8b"
SRC_URI[tinyvec-1.10.0.sha256sum] = "bfa5fdc3bce6191a1dbc8c02d5c8bffcf557bafa17c124c5264a458f1b0613fa"
SRC_URI[tinyvec_macros-0.1.1.sha256sum] = "1f3ccbac311fea05f86f61904b462b55fb3df8837a366dfc601a0161d0532f20"
SRC_URI[tokio-macros-2.5.0.sha256sum] = "6e06d43f1345a3bcd39f6a56dbb7dcab2ba47e68e8ac134855e7e2bdbaf8cab8"
SRC_URI[tokio-native-tls-0.3.1.sha256sum] = "bbae76ab933c85776efabc971569dd6119c580d8f5d448769dec1764bf796ef2"
SRC_URI[tokio-rustls-0.25.0.sha256sum] = "775e0c0f0adb3a2f22a00c4745d728b479985fc15ee7ca6a2608388c5569860f"
SRC_URI[tokio-rustls-0.26.2.sha256sum] = "8e727b36a1a0e8b74c376ac2211e40c2c8af09fb4013c60d910495810f008e9b"
SRC_URI[tokio-stream-0.1.17.sha256sum] = "eca58d7bba4a75707817a2c44174253f9236b2d5fbd055602e9d5c07c139a047"
SRC_URI[tokio-tungstenite-0.27.0.sha256sum] = "489a59b6730eda1b0171fcfda8b121f4bee2b35cba8645ca35c5f7ba3eb736c1"
SRC_URI[tokio-util-0.7.16.sha256sum] = "14307c986784f72ef81c89db7d9e28d6ac26d16213b109ea501696195e6e3ce5"
SRC_URI[tokio-1.47.1.sha256sum] = "89e49afdadebb872d3145a5638b59eb0691ea23e46ca484037cfab3b76b95038"
SRC_URI[toml-0.8.23.sha256sum] = "dc1beb996b9d83529a9e75c17a1686767d148d70663143c7854d8b4a09ced362"
SRC_URI[toml_datetime-0.6.11.sha256sum] = "22cddaf88f4fbc13c51aebbf5f8eceb5c7c5a9da2ac40a13519eb5b0a0e8f11c"
SRC_URI[toml_edit-0.22.27.sha256sum] = "41fe8c660ae4257887cf66394862d21dbca4a6ddd26f04a3560410406a2f819a"
SRC_URI[tower-http-0.6.6.sha256sum] = "adc82fd73de2a9722ac5da747f12383d2bfdb93591ee6c58486e0097890f05f2"
SRC_URI[tower-layer-0.3.3.sha256sum] = "121c2a6cda46980bb0fcd1647ffaf6cd3fc79a013de288782836f6df9c48780e"
SRC_URI[tower-service-0.3.3.sha256sum] = "8df9b6e13f2d32c91b9bd719c00d1958837bc7dec474d94952798cc8e69eeec3"
SRC_URI[tower-0.5.2.sha256sum] = "d039ad9159c98b70ecfd540b2573b97f7f52c3e8d9f8ad57a24b916a536975f9"
SRC_URI[tracing-attributes-0.1.30.sha256sum] = "81383ab64e72a7a8b8e13130c49e3dab29def6d0c7d76a03087b3cf71c5c6903"
SRC_URI[tracing-core-0.1.34.sha256sum] = "b9d12581f227e93f094d3af2ae690a574abb8a2b9b7a96e7cfe9647b2b617678"
SRC_URI[tracing-0.1.41.sha256sum] = "784e0ac535deb450455cbfa28a6f0df145ea1bb7ae51b821cf5e7927fdcfbdd0"
SRC_URI[try-lock-0.2.5.sha256sum] = "e421abadd41a4225275504ea4d6566923418b7f05506fbc9c0fe86ba7396114b"
SRC_URI[tungstenite-0.27.0.sha256sum] = "eadc29d668c91fcc564941132e17b28a7ceb2f3ebf0b9dae3e03fd7a6748eb0d"
SRC_URI[typenum-1.18.0.sha256sum] = "1dccffe3ce07af9386bfd29e80c0ab1a8205a2fc34e4bcd40364df902cfa8f3f"
SRC_URI[uds_windows-1.1.0.sha256sum] = "89daebc3e6fd160ac4aa9fc8b3bf71e1f74fbf92367ae71fb83a037e8bf164b9"
SRC_URI[unicode-ident-1.0.18.sha256sum] = "5a5f39404a5da50712a4c1eecf25e90dd62b613502b7e925fd4e4d19b5c96512"
SRC_URI[unicode-width-0.2.1.sha256sum] = "4a1a07cc7db3810833284e8d372ccdc6da29741639ecc70c9ec107df0fa6154c"
SRC_URI[untrusted-0.9.0.sha256sum] = "8ecb6da28b8a351d773b68d5825ac39017e680750f980f3a1a85cd8dd28a47c1"
SRC_URI[url-2.5.7.sha256sum] = "08bc136a29a3d1758e07a9cca267be308aeebf5cfd5a10f3f67ab2097683ef5b"
SRC_URI[utf-8-0.7.6.sha256sum] = "09cc8ee72d2a9becf2f2febe0205bbed8fc6615b7cb429ad062dc7b7ddd036a9"
SRC_URI[utf8_iter-1.0.4.sha256sum] = "b6c140620e7ffbb22c2dee59cafe6084a59b5ffc27a8859a5f0d494b5d52b6be"
SRC_URI[utf8parse-0.2.2.sha256sum] = "06abde3611657adf66d383f00b093d7faecc7fa57071cce2578660c9f1010821"
SRC_URI[uuid-1.18.0.sha256sum] = "f33196643e165781c20a5ead5582283a7dacbb87855d867fbc2df3f81eddc1be"
SRC_URI[vcpkg-0.2.15.sha256sum] = "accd4ea62f7bb7a82fe23066fb0957d48ef677f6eeb8215f372f52e48bb32426"
SRC_URI[vergen-gitcl-1.0.8.sha256sum] = "b9dfc1de6eb2e08a4ddf152f1b179529638bedc0ea95e6d667c014506377aefe"
SRC_URI[vergen-lib-0.1.6.sha256sum] = "9b07e6010c0f3e59fcb164e0163834597da68d1f864e2b8ca49f74de01e9c166"
SRC_URI[vergen-9.0.6.sha256sum] = "6b2bf58be11fc9414104c6d3a2e464163db5ef74b12296bda593cac37b6e4777"
SRC_URI[version-compare-0.1.1.sha256sum] = "579a42fc0b8e0c63b76519a339be31bed574929511fa53c1a3acae26eb258f29"
SRC_URI[version-compare-0.2.0.sha256sum] = "852e951cb7832cb45cb1169900d19760cfa39b82bc0ea9c0e5a14ae88411c98b"
SRC_URI[version_check-0.9.5.sha256sum] = "0b928f33d975fc6ad9f86c8f283853ad26bdd5b10b7f1542aa2fa15e2289105a"
SRC_URI[walkdir-2.5.0.sha256sum] = "29790946404f91d9c5d06f9874efddea1dc06c5efe94541a7d6863108e3a5e4b"
SRC_URI[want-0.3.1.sha256sum] = "bfa7760aed19e106de2c7c0b581b509f2f25d3dacaf737cb82ac61bc6d760b0e"
SRC_URI[wasi-0.11.1+wasi-snapshot-preview1.sha256sum] = "ccf3ec651a847eb01de73ccad15eb7d99f80485de043efb2f370cd654f4ea44b"
SRC_URI[wasi-0.14.2+wasi-0.2.4.sha256sum] = "9683f9a5a998d873c0d21fcbe3c083009670149a8fab228644b8bd36b2c48cb3"
SRC_URI[wasm-bindgen-backend-0.2.100.sha256sum] = "2f0a0651a5c2bc21487bde11ee802ccaf4c51935d0d3d42a6101f98161700bc6"
SRC_URI[wasm-bindgen-futures-0.4.50.sha256sum] = "555d470ec0bc3bb57890405e5d4322cc9ea83cebb085523ced7be4144dac1e61"
SRC_URI[wasm-bindgen-macro-support-0.2.100.sha256sum] = "8ae87ea40c9f689fc23f209965b6fb8a99ad69aeeb0231408be24920604395de"
SRC_URI[wasm-bindgen-macro-0.2.100.sha256sum] = "7fe63fc6d09ed3792bd0897b314f53de8e16568c2b3f7982f468c0bf9bd0b407"
SRC_URI[wasm-bindgen-shared-0.2.100.sha256sum] = "1a05d73b933a847d6cccdda8f838a22ff101ad9bf93e33684f39c1f5f0eece3d"
SRC_URI[wasm-bindgen-0.2.100.sha256sum] = "1edc8929d7499fc4e8f0be2262a241556cfc54a0bea223790e71446f2aab1ef5"
SRC_URI[web-sys-0.3.77.sha256sum] = "33b6dd2ef9186f1f2072e409e99cd22a975331a6b3591b12c764e0e55c60d5d2"
SRC_URI[web-time-1.1.0.sha256sum] = "5a6580f308b1fad9207618087a65c04e7a10bc77e02c8e84e9b00dd4b12fa0bb"
SRC_URI[webpki-roots-0.26.11.sha256sum] = "521bc38abb08001b01866da9f51eb7c5d647a19260e00054a8c7fd5f9e57f7a9"
SRC_URI[webpki-roots-1.0.2.sha256sum] = "7e8983c3ab33d6fb807cfcdad2491c4ea8cbc8ed839181c7dfd9c67c83e261b2"
SRC_URI[webpki-0.22.4.sha256sum] = "ed63aea5ce73d0ff405984102c42de94fc55a6b75765d621c65262469b3c9b53"
SRC_URI[which-4.4.2.sha256sum] = "87ba24419a2078cd2b0f2ede2691b6c66d8e47836da3b6db8265ebad47afbfc7"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.10.sha256sum] = "0978bf7171b3d90bac376700cb56d606feb40f251a475a5d6634613564460b22"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-collections-0.2.0.sha256sum] = "3beeceb5e5cfd9eb1d76b381630e82c4241ccd0d27f1a39ed41b2760b255c5e8"
SRC_URI[windows-core-0.54.0.sha256sum] = "12661b9c89351d684a50a8a643ce5f608e20243b9fb84687800163429f161d65"
SRC_URI[windows-core-0.61.2.sha256sum] = "c0fdd3ddb90610c7638aa2b3a3ab2904fb9e5cdbecc643ddb3647212781c4ae3"
SRC_URI[windows-future-0.2.1.sha256sum] = "fc6a41e98427b19fe4b73c550f060b59fa592d7d686537eebf9385621bfbad8e"
SRC_URI[windows-implement-0.60.0.sha256sum] = "a47fddd13af08290e67f4acabf4b459f647552718f683a7b415d290ac744a836"
SRC_URI[windows-interface-0.59.1.sha256sum] = "bd9211b69f8dcdfa817bfd14bf1c97c9188afa36f4750130fcdf3f400eca9fa8"
SRC_URI[windows-link-0.1.3.sha256sum] = "5e6ad25900d524eaabdbbb96d20b4311e1e7ae1699af4fb28c17ae66c80d798a"
SRC_URI[windows-numerics-0.2.0.sha256sum] = "9150af68066c4c5c07ddc0ce30421554771e528bde427614c61038bc2c92c2b1"
SRC_URI[windows-registry-0.5.3.sha256sum] = "5b8a9ed28765efc97bbc954883f4e6796c33a06546ebafacbabee9696967499e"
SRC_URI[windows-result-0.1.2.sha256sum] = "5e383302e8ec8515204254685643de10811af0ed97ea37210dc26fb0032647f8"
SRC_URI[windows-result-0.3.4.sha256sum] = "56f42bd332cc6c8eac5af113fc0c1fd6a8fd2aa08a0119358686e5160d0586c6"
SRC_URI[windows-strings-0.4.2.sha256sum] = "56e6c93f3a0c3b36176cb1327a4958a0353d5d166c2a35cb268ace15e91d3b57"
SRC_URI[windows-sys-0.45.0.sha256sum] = "75283be5efb2831d37ea142365f009c02ec203cd29a3ebecbc093d52315b66d0"
SRC_URI[windows-sys-0.52.0.sha256sum] = "282be5f36a8ce781fad8c8ae18fa3f9beff57ec1b52cb3de0789201425d9a33d"
SRC_URI[windows-sys-0.59.0.sha256sum] = "1e38bc4d79ed67fd075bcc251a1c39b32a1776bbe92e5bef1f0bf1f8c531853b"
SRC_URI[windows-sys-0.60.2.sha256sum] = "f2f500e4d28234f72040990ec9d39e3a6b950f9f22d3dba18416c35882612bcb"
SRC_URI[windows-targets-0.42.2.sha256sum] = "8e5180c00cd44c9b1c88adb3693291f1cd93605ded80c250a75d472756b4d071"
SRC_URI[windows-targets-0.52.6.sha256sum] = "9b724f72796e036ab90c1021d4780d4d3d648aca59e491e6b98e725b84e99973"
SRC_URI[windows-targets-0.53.3.sha256sum] = "d5fe6031c4041849d7c496a8ded650796e7b6ecc19df1a431c1a363342e5dc91"
SRC_URI[windows-threading-0.1.0.sha256sum] = "b66463ad2e0ea3bbf808b7f1d371311c80e115c0b71d60efc142cafbcfb057a6"
SRC_URI[windows-0.54.0.sha256sum] = "9252e5725dbed82865af151df558e754e4a3c2c30818359eb17465f1346a1b49"
SRC_URI[windows-0.61.3.sha256sum] = "9babd3a767a4c1aef6900409f85f5d53ce2544ccdfaa86dad48c91782c6d6893"
SRC_URI[windows_aarch64_gnullvm-0.42.2.sha256sum] = "597a5118570b68bc08d8d59125332c54f1ba9d9adeedeef5b99b02ba2b0698f8"
SRC_URI[windows_aarch64_gnullvm-0.52.6.sha256sum] = "32a4622180e7a0ec044bb555404c800bc9fd9ec262ec147edd5989ccd0c02cd3"
SRC_URI[windows_aarch64_gnullvm-0.53.0.sha256sum] = "86b8d5f90ddd19cb4a147a5fa63ca848db3df085e25fee3cc10b39b6eebae764"
SRC_URI[windows_aarch64_msvc-0.42.2.sha256sum] = "e08e8864a60f06ef0d0ff4ba04124db8b0fb3be5776a5cd47641e942e58c4d43"
SRC_URI[windows_aarch64_msvc-0.52.6.sha256sum] = "09ec2a7bb152e2252b53fa7803150007879548bc709c039df7627cabbd05d469"
SRC_URI[windows_aarch64_msvc-0.53.0.sha256sum] = "c7651a1f62a11b8cbd5e0d42526e55f2c99886c77e007179efff86c2b137e66c"
SRC_URI[windows_i686_gnu-0.42.2.sha256sum] = "c61d927d8da41da96a81f029489353e68739737d3beca43145c8afec9a31a84f"
SRC_URI[windows_i686_gnu-0.52.6.sha256sum] = "8e9b5ad5ab802e97eb8e295ac6720e509ee4c243f69d781394014ebfe8bbfa0b"
SRC_URI[windows_i686_gnu-0.53.0.sha256sum] = "c1dc67659d35f387f5f6c479dc4e28f1d4bb90ddd1a5d3da2e5d97b42d6272c3"
SRC_URI[windows_i686_gnullvm-0.52.6.sha256sum] = "0eee52d38c090b3caa76c563b86c3a4bd71ef1a819287c19d586d7334ae8ed66"
SRC_URI[windows_i686_gnullvm-0.53.0.sha256sum] = "9ce6ccbdedbf6d6354471319e781c0dfef054c81fbc7cf83f338a4296c0cae11"
SRC_URI[windows_i686_msvc-0.42.2.sha256sum] = "44d840b6ec649f480a41c8d80f9c65108b92d89345dd94027bfe06ac444d1060"
SRC_URI[windows_i686_msvc-0.52.6.sha256sum] = "240948bc05c5e7c6dabba28bf89d89ffce3e303022809e73deaefe4f6ec56c66"
SRC_URI[windows_i686_msvc-0.53.0.sha256sum] = "581fee95406bb13382d2f65cd4a908ca7b1e4c2f1917f143ba16efe98a589b5d"
SRC_URI[windows_x86_64_gnu-0.42.2.sha256sum] = "8de912b8b8feb55c064867cf047dda097f92d51efad5b491dfb98f6bbb70cb36"
SRC_URI[windows_x86_64_gnu-0.52.6.sha256sum] = "147a5c80aabfbf0c7d901cb5895d1de30ef2907eb21fbbab29ca94c5b08b1a78"
SRC_URI[windows_x86_64_gnu-0.53.0.sha256sum] = "2e55b5ac9ea33f2fc1716d1742db15574fd6fc8dadc51caab1c16a3d3b4190ba"
SRC_URI[windows_x86_64_gnullvm-0.42.2.sha256sum] = "26d41b46a36d453748aedef1486d5c7a85db22e56aff34643984ea85514e94a3"
SRC_URI[windows_x86_64_gnullvm-0.52.6.sha256sum] = "24d5b23dc417412679681396f2b49f3de8c1473deb516bd34410872eff51ed0d"
SRC_URI[windows_x86_64_gnullvm-0.53.0.sha256sum] = "0a6e035dd0599267ce1ee132e51c27dd29437f63325753051e71dd9e42406c57"
SRC_URI[windows_x86_64_msvc-0.42.2.sha256sum] = "9aec5da331524158c6d1a4ac0ab1541149c0b9505fde06423b02f5ef0106b9f0"
SRC_URI[windows_x86_64_msvc-0.52.6.sha256sum] = "589f6da84c646204747d1270a2a5661ea66ed1cced2631d546fdfb155959f9ec"
SRC_URI[windows_x86_64_msvc-0.53.0.sha256sum] = "271414315aff87387382ec3d271b52d7ae78726f5d44ac98b4f4030c91880486"
SRC_URI[winnow-0.7.13.sha256sum] = "21a0236b59786fed61e2a80582dd500fe61f18b5dca67a4a067d0bc9039339cf"
SRC_URI[wit-bindgen-rt-0.39.0.sha256sum] = "6f42320e61fe2cfd34354ecb597f86f413484a798ba44a8ca1165c58d42da6c1"
SRC_URI[writeable-0.6.1.sha256sum] = "ea2f10b9bb0928dfb1b42b65e1f9e36f7f54dbdf08457afefb38afcdec4fa2bb"
SRC_URI[yoke-derive-0.8.0.sha256sum] = "38da3c9736e16c5d3c8c597a9aaa5d1fa565d0532ae05e27c24aa62fb32c0ab6"
SRC_URI[yoke-0.8.0.sha256sum] = "5f41bb01b8226ef4bfd589436a297c53d118f65921786300e427be8d487695cc"
SRC_URI[zbus-5.10.0.sha256sum] = "67a073be99ace1adc48af593701c8015cd9817df372e14a1a6b0ee8f8bf043be"
SRC_URI[zbus_macros-5.10.0.sha256sum] = "0e80cd713a45a49859dcb648053f63265f4f2851b6420d47a958e5697c68b131"
SRC_URI[zbus_names-4.2.0.sha256sum] = "7be68e64bf6ce8db94f63e72f0c7eb9a60d733f7e0499e628dfab0f84d6bcb97"
SRC_URI[zerocopy-derive-0.8.26.sha256sum] = "9ecf5b4cc5364572d7f4c329661bcc82724222973f2cab6f050a4e5c22f75181"
SRC_URI[zerocopy-0.8.26.sha256sum] = "1039dd0d3c310cf05de012d8a39ff557cb0d23087fd44cad61df08fc31907a2f"
SRC_URI[zerofrom-derive-0.1.6.sha256sum] = "d71e5d6e06ab090c67b5e44993ec16b72dcbaabc526db883a360057678b48502"
SRC_URI[zerofrom-0.1.6.sha256sum] = "50cc42e0333e05660c3587f3bf9d0478688e15d870fab3346451ce7f8c9fbea5"
SRC_URI[zeroize-1.8.1.sha256sum] = "ced3678a2879b30306d323f4542626697a464a97c0a07c9aebf7ebca65cd4dde"
SRC_URI[zerotrie-0.2.2.sha256sum] = "36f0bbd478583f79edad978b407914f61b2972f5af6fa089686016be8f9af595"
SRC_URI[zerovec-derive-0.11.1.sha256sum] = "5b96237efa0c878c64bd89c436f661be4e46b2f3eff1ebb976f7ef2321d2f58f"
SRC_URI[zerovec-0.11.4.sha256sum] = "e7aa2bd55086f1ab526693ecbe444205da57e25f4489879da80635a46d90e73b"
SRC_URI[zvariant-5.7.0.sha256sum] = "999dd3be73c52b1fccd109a4a81e4fcd20fab1d3599c8121b38d04e1419498db"
SRC_URI[zvariant_derive-5.7.0.sha256sum] = "6643fd0b26a46d226bd90d3f07c1b5321fe9bb7f04673cb37ac6d6883885b68e"
SRC_URI[zvariant_utils-3.2.1.sha256sum] = "c6949d142f89f6916deca2232cf26a8afacf2b9fdc35ce766105e104478be599"

# FIXME: update generateme with the real MD5 of the license file
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=98b2b0c9a6081259c441045ca68b640f \
"

SUMMARY = "An open source client library for Spotify, with support for Spotify Connect"
HOMEPAGE = "https://github.com/librespot-org/librespot"
LICENSE = "MIT"
