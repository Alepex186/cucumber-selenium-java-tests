# 🧪 Automatización de pruebas - Parabank (Java + Selenium + Cucumber + JUnit 5)


# 🚀 ¿ Cómo ejecutar las pruebas ?


1. Dar permisos a los ejecutables (solo Linux/Mac):
   
   - `sudo chmod +x run_parabank_webserver.sh gradlew shutdown_parabank_webserver.sh`

3. Iniciar el servidor de Parabank:
   - Windows: `run_parabank_webserver.bat`
   - Linux/Mac: `./run_parabank_webserver.sh`
   > ⏳ Espera ~30 segundos a que el servidor inicie.

4. Ejecutar los tests:
   - Windows: `gradlew.bat test`
   - Linux/Mac: `./gradlew test`


# ⚙️ Configuración
El archivo [`app/src/test/resources/config.properties`] permite ajustar el navegador, el modo headless asi como otras configuraciones:

## Propiedades por defecto
- BROWSER=chrome
- HEADLESS=false

También es posible definir estas propiedades mediante variables de entorno, lo cual es útil en entornos como Jenkins o CI/CD.      
   - Windows(cmd): `set HEADLESS=true`
   - Linux/Mac: `export HEADLESS=true`

# ⚠️ Error conocido: Timeout en el registro

En el escenario `Registro exitoso con datos válidos`, en el step  
`Then deberia ver la pagina principal del usuario`, puede aparecer este error:

org.openqa.selenium.TimeoutException: Expected condition failed: waiting for text ('Your account was created successfully') to be present in element found by By.tagName: body (tried for 20 second(s) with 500 milliseconds interval)


### 🔍 Causa:  
Este error no se debe a las pruebas, sino a un bug interno de la aplicación Parabank que interpreta que el usuario a crear ya existe en la base de datos, incluso cuando se utilizan datos completamente nuevos.



### 🛠️ Solución
 
**Apagar el servidor web ejecutando:**

    Windows: shutdown_parabank_webserver.bat

    Linux/Mac: shutdown_parabank_webserver.sh

**Volver a ejecutar el servidor:**

    Windows: run_parabank_webserver.bat

    Linux/Mac: run_parabank_webserver.sh
