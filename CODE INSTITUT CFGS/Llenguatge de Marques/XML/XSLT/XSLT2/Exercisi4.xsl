<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <table bgcolor="red">
                <h1>Mis peliculas clasicas preferidas</h1>
                <tr>
                    <td>
                        Titulo
                    </td>
                    <td>
                        Director
                    </td>
                    <td>
                        Pais
                    </td>
                    <td>
                        Año
                    </td>
                    <td>
                        Duración
                    </td>
                    <td>
                        Genero
                    </td>
                </tr>
                <xsl:for-each select="//pelicula">
                    <tr>
                        <td>
                            <p>
                                <xsl:value-of select="titulo" />
                            </p>
                        </td>
                        <td>
                            <p>
                                <xsl:value-of select="direccion" />
                            </p>
                        </td>
                        <td>
                            <p>
                                <xsl:value-of select="pais" />
                            </p>
                        </td>
                        <td>
                            <p>
                                <xsl:value-of select="año" />
                            </p>
                        </td>
                        <td>
                            <p>
                                <xsl:value-of select="duracion" />
                            </p>
                        </td>
                        <td>
                            <p>
                                <xsl:value-of select="genero" />
                            </p>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </html>
    </xsl:template>
</xsl:stylesheet>