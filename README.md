# API RESTful de Gestión de Company, Job y Review

Este proyecto es una API RESTful desarrollada con Spring Boot que permite realizar operaciones CRUD (Create, Read, Update, Delete) sobre los recursos `Company`, `Job` y `Review`. La API está diseñada para gestionar una base de datos PostgreSQL y utiliza contenedores Docker para facilitar la configuración y despliegue de la base de datos y de la herramienta de administración PgAdmin.

## Descripción del Proyecto

La API permite realizar las siguientes operaciones:

- **Company**: Gestión de compañías, incluyendo la creación, actualización, eliminación y consulta de compañías.
- **Job**: Gestión de ofertas de trabajos asociados a compañías, permitiendo registrar nuevos puestos de trabajo y asociarlos a una compañía específica.
- **Review**: Administración de reseñas sobre las compañías, que pueden ser creadas, actualizadas, eliminadas y consultadas.

## Arquitectura y Características de la API

1. **Estilo RESTful**: La API sigue los principios REST, estructurando cada entidad (`Company`, `Job`, `Review`) como un recurso al que se accede mediante URL únicas y operando sobre ellos mediante métodos HTTP estándar:
   - `GET` para consultar recursos.
   - `POST` para crear nuevos recursos.
   - `PUT` para actualizar recursos existentes.
   - `DELETE` para eliminar recursos.

2. **Sin Estado (Stateless)**: La API es stateless, lo que significa que cada solicitud realizada desde el cliente (por ejemplo, mediante Postman) incluye toda la información necesaria para procesarla, sin depender de solicitudes anteriores.

3. **Formato de Datos**: La comunicación de datos entre el cliente y el servidor se realiza en formato JSON, facilitando el intercambio y la interpretación de información.

4. **Docker**: Se utilizan contenedores Docker para desplegar PostgreSQL (base de datos) y PgAdmin (herramienta de administración de la base de datos). Esto asegura un entorno de desarrollo y producción consistente y fácil de configurar.

## Endpoints

Aquí se describen algunos de los endpoints principales de la API:

- **Company**
  - `GET /companies` - Obtiene una lista de todas las compañías.
  - `GET /companies/{id}` - Obtiene una compañía específica por su ID.
  - `POST /companies` - Crea una nueva compañía.
  - `PUT /companies/{id}` - Actualiza la información de una compañía.
  - `DELETE /companies/{id}` - Elimina una compañía.

- **Job**
  - `GET /jobs` - Obtiene una lista de todos los trabajos.
  - `GET /jobs/{id}` - Obtiene un trabajo específico por su ID.
  - `POST /jobs` - Crea un nuevo trabajo asociado a una compañía.
  - `PUT /jobs/{id}` - Actualiza un trabajo existente.
  - `DELETE /jobs/{id}` - Elimina un trabajo.

- **Review**
  - `GET /companies/{companyId}/reviews` - Obtiene una lista de todas las reseñas.
  - `GET /companies/{companyId}/reviews/{id}` - Obtiene una reseña específica por su ID.
  - `POST /companies/{companyId}/reviews` - Crea una nueva reseña para una compañía.
  - `PUT /companies/{companyId}/reviews/{id}` - Actualiza una reseña existente.
  - `DELETE /companies/{companyId}/reviews/{id}` - Elimina una reseña.
