SUMMARY = "pygobject - Python package"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a916467b91076e631dd8edb7424769c7"

DEPENDS = "python3 glib-2.0 python3-pycairo python3-pkgconfig cairo"

SRC_URI = "https://github.com/GNOME/pygobject/archive/refs/tags/3.42.1.tar.gz"

S = "${WORKDIR}/pygobject-${PV}"

inherit distutils3 pkgconfig gobject-introspection


SRC_URI[md5sum] = "9d0fcbfa964f57c591001775862454d5"
SRC_URI[sha256sum] = "53fff1eef7f94533f18164c2df2fcc16cd447aac71f34efc8a735a21bc3bebd5"

UNKNOWN_CONFIGURE_WHITELIST = "introspection"

BBCLASSEXTEND = "native"
