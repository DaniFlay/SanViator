<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output method="xml" indent="yes"/>
	<xsl:template match="facturas">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm" margin-top="1cm" margin-bottom="1cm" margin-left="3cm" margin-right="2cm">
					<fo:region-body margin-top="1cm"/>
					<fo:region-before extent="3cm"/>
					<fo:region-after extent="1.5cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<xsl:for-each select="factura">
			<fo:page-sequence master-reference="A4">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:external-graphic src="url(file:\\\C:\Users\Alumno\Downloads\logoPcComponentes.png)" content-width="16cm"/>
					</fo:block>
					<fo:table text-align="left">
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="7.5cm" padding="0.3cm">
									<fo:block>
										<xsl:value-of select="datosVendedor/nombre"/>
									</fo:block>
									<fo:block>
										<xsl:value-of select="datosVendedor/CIF"/>
									</fo:block>
									<fo:block>
										<xsl:value-of select="datosVendedor/direccion/calle"/>
										<xsl:value-of select="datosVendedor/direccion/numero"/>
										<xsl:value-of select="datosVendedor/direccion/extra"/>
									</fo:block>
									<fo:block>
										<xsl:value-of select="datosVendedor/direccion/poblacion"/>
									</fo:block>
									<fo:block>
										<xsl:value-of select="datosVendedor/direccion/codigoPostal"/>
										<xsl:value-of select="datosVendedor/direccion/provincia"/>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell width="1cm" padding="0.3cm">
									<fo:block/>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="7.5cm" padding="0.3cm">
									<fo:block>Nombre:<xsl:value-of select="datosComprador/nombre"/>
									</fo:block>
									<fo:block>Direccion:<xsl:value-of select="datosComprador/direccion/calle"/>
										<xsl:value-of select="datosComprador/direccion/numero"/>
										<xsl:value-of select="datosComprador/direccion/extra"/>
									</fo:block>
									<fo:block>Poblacion:<xsl:value-of select="datosComprador/direccion/poblacion"/>
										<xsl:value-of select="datosComprador/direccion/numero"/>
										<xsl:value-of select="datosComprador/direccion/extra"/>
									</fo:block>
									<fo:block>NIF/CIF:<xsl:value-of select="datosComprador/identificacion/@tipo"/>: <xsl:value-of select="datosComprador/identificacion"/>
									</fo:block>
									<fo:block>Telefono:<xsl:value-of select="datosComprador/telefono"/>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:table>
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										<fo:leader/>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:table text-align="left" border-style="solid" border-width="0.5mm">
						<fo:table-body>
							<fo:table-row border-style="solid" border-width="0.5mm">
								<fo:table-cell border-style="solid" border-width="0.5mm" width="4cm" padding="0.3cm">
									<fo:block>Nº Factura: <xsl:value-of select="@numFactura"/>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="4cm" padding="0.3cm">
									<fo:block>Fecha: <xsl:value-of select="fecha/dia"/>-<xsl:value-of select="fecha/mes"/>-<xsl:value-of select="fecha/anyo"/>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="8cm" padding="0.3cm">
									<fo:block>Forma de pago: <xsl:value-of select="formaPago"/>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:table>
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										<fo:leader/>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:table text-align="left" border-style="solid" border-width="0.5mm">
						<fo:table-header background-color="#CCCCCC">
							<fo:table-row>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="3cm" padding="0.3cm">
									<fo:block>Cod</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="6cm" padding="0.3cm">
									<fo:block>Artículo</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="2.5cm" padding="0.3cm">
									<fo:block>Precio</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="2cm" padding="0.1cm">
									<fo:block>Und</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="2.5cm" padding="0.3cm">
									<fo:block>Total</fo:block>
								</fo:table-cell>
							</fo:table-row>
									<fo:table-row background-color="#e6e6e6">
									<fo:table-cell number-columns-spanned="5" border-style="solid" border-width="0.5mm" padding="0.1cm">
									<fo:block>
										Nº de Albarán: <xsl:value-of select="albaran"/>
									</fo:block>
									</fo:table-cell>
									</fo:table-row>
									
						</fo:table-header>
						<fo:table-body>
							<xsl:for-each select="productos/producto">
								<fo:table-row border-style="solid" border-width="0.5mm">
									<fo:table-cell width="3cm" border-style="solid" border-width="0.5mm" padding="0.3cm">
										<fo:block>
											<xsl:value-of select="@id"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="6cm" border-style="solid" border-width="0.5mm" padding="0.3cm">
										<fo:block>
											<xsl:value-of select="nombre"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="3cm" border-style="solid" border-width="0.5mm" padding="0.3cm">
										<fo:block>
											<xsl:value-of select="precio"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="1cm" border-style="solid" border-width="0.5mm" padding="0.3cm">
										<fo:block>
											<xsl:value-of select="numUnidades"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="3cm" border-style="solid" border-width="0.5mm" padding="0.3cm">
										<fo:block>
											<xsl:value-of select="total"/>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</xsl:for-each>
						</fo:table-body>
					</fo:table>
					<fo:table>
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										<fo:leader/>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<fo:table text-align="right">
						<fo:table-header background-color="#CCCCCC">
							<fo:table-row>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="7cm" padding="0.3cm">
									<fo:block>SUBTOTAL</fo:block>
								</fo:table-cell>
								<fo:table-cell width="3cm" border-style="solid" border-width="0.5mm" padding="0.3cm">
									<fo:block>IVA</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="3cm" padding="0.3cm">
									<fo:block>REC.EQUIV</fo:block>
								</fo:table-cell>
								<fo:table-cell border-style="solid" border-width="0.5mm" width="3cm" padding="0.3cm">
									<fo:block>TOTAL</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-header>
						<fo:table-body>
							<fo:table-row>
								<fo:table-cell>
									<fo:block>
										<fo:leader/>
									</fo:block>
								</fo:table-cell>
							</fo:table-row>

								<fo:table-row border-style="solid" border-width="0.5mm">
									<fo:table-cell border-style="solid" border-width="0.5mm" width="7cm" padding="0.3cm">
										<fo:block>
											<xsl:value-of select="subtotal"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell width="3cm" border-style="solid" border-width="0.5mm" padding="0.3cm">
										<fo:block>(<xsl:value-of select="iva/@tipo"/>)~</fo:block>
										<fo:block>
											<xsl:value-of select="iva"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-style="solid" border-width="0.5mm" width="3cm" padding="0.3cm">
										<fo:block>--</fo:block>
									</fo:table-cell>
									<fo:table-cell border-style="solid" border-width="0.5mm" width="3cm" padding="0.3cm">
										<fo:block>
											<xsl:value-of select="total"/>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>

						</fo:table-body>
					</fo:table>
					
					
				</fo:flow>
			</fo:page-sequence>
			</xsl:for-each>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>