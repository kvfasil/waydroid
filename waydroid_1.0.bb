SUMMARY = "Waydroid implementation on RDK stack"

LICENSE = "CLOSED"
PV = "1.3.3"

SRC_URI = "https://github.com/waydroid/waydroid/archive/refs/tags/${PV}.zip;protocol=http"
 
SRC_URI[md5sum] = "4f477d6397b333d6fbff953606ea3a1c"
SRC_URI[sha256sum] = "98340888e31c4c033db613bcdb45d8884700acf03458bf46b84dac3e1e771714"
 
RDEPENDS_${PN} = "python python3 python3-pip lxc python3-pkgconfig python3-pycairo python3-pygobject"

S = "${WORKDIR}/${PN}-${PV}"
PYTHON_DIR = "python3.8"

PREFIX = "/usr"
WAYDROID_DIR = "${PREFIX}/lib/waydroid"
BIN_DIR = "${PREFIX}/bin"
APPS_DIR = "${PREFIX}/share/applications"
METAINFO_DIR = "${PREFIX}/share/metainfo"
SYSD_DIR = "${PREFIX}/lib/systemd/system"

INSTALL_WAYDROID_DIR = "${D}${WAYDROID_DIR}"
INSTALL_BIN_DIR = "${D}${BIN_DIR}"
INSTALL_APPS_DIR = "${D}${APPS_DIR}"
INSTALL_METAINFO_DIR = "${D}${METAINFO_DIR}"
INSTALL_SYSD_DIR = "${D}${SYSD_DIR}"


do_install() {


install -d ${INSTALL_WAYDROID_DIR} ${INSTALL_BIN_DIR} ${INSTALL_APPS_DIR} ${INSTALL_METAINFO_DIR}
cp -a ${S}/data ${S}/tools ${S}/waydroid.py ${INSTALL_WAYDROID_DIR}
ln -sf ${WAYDROID_DIR}/waydroid.py ${INSTALL_BIN_DIR}/waydroid
mv ${INSTALL_WAYDROID_DIR}/data/*.desktop ${INSTALL_APPS_DIR}
mv ${INSTALL_WAYDROID_DIR}/data/*.metainfo.xml ${INSTALL_METAINFO_DIR}

install -d ${INSTALL_SYSD_DIR}
cp ${S}/systemd/waydroid-container.service ${INSTALL_SYSD_DIR}

}


FILES_${PN} = " \
  /usr/bin/* \
  /usr/lib/* \
  /usr/share/metainfo/* \
  /usr/share/applications/* \
  /usr/lib/waydroid/* \
	${systemd_unitdir}/system/waydroid-container.service \
"
