# Iniciar sesión
Resumen del funcionamiento
Inicializa la interfaz mediante ActivityMainBinding, lo que permite acceder a los componentes del diseño sin usar findViewById.
Define las credenciales válidas que se utilizarán para la autenticación:
Correo: user@tic.unam.mx
Contraseña: d1pl0m0v1l35?
Configura los márgenes de la pantalla (Edge-to-Edge) para que la interfaz se adapte correctamente a las barras del sistema.
Deshabilita el botón "Login" al iniciar la aplicación.
Escucha los cambios en los campos de correo y contraseña mediante addTextChangedListener; cuando ambos contienen texto, habilita el botón de inicio de sesión.
Valida los datos ingresados al presionar el botón:
Verifica que el correo no esté vacío.
Comprueba que el correo tenga un formato válido utilizando Patterns.EMAIL_ADDRESS.
Verifica que la contraseña no esté vacía.
Compara las credenciales capturadas con las credenciales predefinidas.
Si coinciden, crea un Intent, envía el correo a WelcomeActivity, abre esa pantalla y finaliza MainActivity para impedir regresar al login con el botón Atrás.
Si no coinciden, muestra un mensaje de error mediante un Toast indicando que las credenciales son incorrectas.
