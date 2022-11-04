SUMMARY = "Waydroid implementation on RDK stack"

LICENSE = "CLOSED"

PV = "1.1.1"

SRC_URI = "https://github.com/erfanoabdi/gbinder-python/archive/refs/tags/${PV}.zip;protocol=http"

SRC_URI[sha256sum] = "5d0ebdd1dc323aa87e371aff05f7dd7d18777475b99261335d034779ab171f0a"

S = "${WORKDIR}/${PN}-${PV}"
PYTHON_DIR = "python3.8"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${libdir}	
	install -d ${D}${sysconfdir}	
	install -d ${D}${libdir}/waydroid 
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages 
	install -d ${D}${systemd_unitdir}/system
	
	
}

RDEPENDS_${PN} = "python python3 python3-pip python3-cython"

FILES_${PN} = " \
	${libdir}/${PYTHON_DIR}/site-packages/* \
"
