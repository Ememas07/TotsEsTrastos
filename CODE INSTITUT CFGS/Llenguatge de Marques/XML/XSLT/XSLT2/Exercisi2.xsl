<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <table>
                <h1>Mis peliculas clasicas preferidas</h1>
                <tr>
                    <td>
                        Titulo
                    </td>
                    <td>
                        Director
                    </td>
                </tr>
                <tr>
                    <td>
                        <p>
                            <xsl:value-of select="//titulo" />
                        </p>
                    </td>
                    <td>
                        <p>
                            <xsl:value-of select="//direccion" />
                        </p>
                    </td>
                </tr>
            </table>
        </html>
    </xsl:template>
</xsl:stylesheet>