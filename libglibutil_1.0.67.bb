SUMMARY = "Waydroid implementation on RDK stack"

LICENSE = "CLOSED"

PV = "1.0.67"

SRC_URI = "https://github.com/sailfishos/libglibutil/archive/refs/tags/${PV}.zip;protocol=http"
SRC_URI[sha256sum] = "444efb8a0c7f1ec61c48f8b649b58da951ed0b3213567ecb04653909e319864a"

S = "${WORKDIR}/${PN}-${PV}"
PYTHON_DIR = "python3.8"


DEPENDS = "glib-2.0 "

inherit base pkgconfig

do_configure () {
    # Specify any needed configure commands here
    :
}

do_compile () {
    # You will almost certainly need to add additional arguments here
    oe_runmake
}

PREFIX = "/usr"
LIB_DIR = "${PREFIX}/lib"
INSTALL_LIB_DIR = "${D}${LIB_DIR}"

#do_install() {		
#install -d ${INSTALL_LIB_DIR}
#install -m 755 build/release/libglibutil.so.1.0.67 ${INSTALL_LIB_DIR}
#ln -sf ${LIB_DIR}/libglibutil.so.1.0.67 ${INSTALL_LIB_DIR}/libglibutil.so.1.0
#ln -sf ${LIB_DIR}/libglibutil.so.1.0 ${INSTALL_LIB_DIR}/libglibutil.so.1
#}

do_install () {
         oe_runmake install-dev DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} INCLUDEDIR=${includedir}
}

