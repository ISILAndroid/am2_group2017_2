# am2_group2017_2
Curso de Aplicaciones Móviles 2 - Grupo 2017 02

## Semana 11

- Conexión Remota

- Patrones y Arquitectura de aplicaciones móviles

- Unidad de Aprendizaje 3

## Conexión Remota

- Seguiremos viendo el crud , ahora consumiendo servicios RestFul con Json

- Registrar notas por usuario

	- POST

	- URL : https://obscure-earth-55790.herokuapp.com/api/notes/register

	- Request :
	```
		{
			"name":"My nota",
			"description":"Esta es un nota del server",
			"path": "",
			"userId": "59e0540d429d3f501d6493de"
		}
	```
	- Response :
	```
		{
		    "__v": 0,
		    "id": "59f3c5f5145d3812006ab70d",
		    "name": "My nota",
		    "description": "Esta es un nota del server",
		    "path": "",
		    "userId": "59e0540d429d3f501d6493de",
		    "_id": "59f3c5f5145d3812006ab70d"
		}
	```
- Listas notas

		- GET

		- URL : https://obscure-earth-55790.herokuapp.com/api/notes

		- Response :
		```
			{
			    "msg": "success",
			    "status": 200,
			    "data": [
			        {
			            "_id": "59f3c5f5145d3812006ab70d",
			            "id": "59f3c5f5145d3812006ab70d",
			            "name": "My nota",
			            "description": "Esta es un nota del server",
			            "path": "",
			            "userId": "59e0540d429d3f501d6493de",
			            "__v": 0
			        }
			    ]
			}
		```
## Patrones y Arquitectura de aplicaciones móviles

- Explicaremos un poco de las diferentes opciones de patrones y arquitecturas para el desarrollo de aplicaciones móviles.

- Usaremos el patrón Model View Presenter (MVP)

## Unidad de Aprendizaje 3

- Daremos la unidad de aprendizaje basada en avances de sus proyecto.

- Se abarcará los temas de persistencia de datos y conexión remota.

## Referencias

 - Principios S.O.L.I.D https://academy.realm.io/posts/learning-path-solid-principles-for-android/

 - Android Architecture Blueprints https://github.com/googlesamples/android-architecture

 - MVP Pattern (Microsoft) https://msdn.microsoft.com/en-us/library/ff649571.aspx

 - GUI Architectures (Martin Fowler) https://martinfowler.com/eaaDev/uiArchs.html

 - MVC, MVP , MVVM (Realm) https://academy.realm.io/posts/eric-maxwell-mvc-mvp-and-mvvm-on-android/




*** Semana 11 - Viernes 27 de Octubre ***
