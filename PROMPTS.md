gemini: dame el codigo para desarrollar un proyecto backend (API)de un sistema donde distintos usuarios interactúan con la disponibilidad y reservas de habitaciones de una cadena hotelera con varias sucursales.
Entidades mínimas:
Hotel/Sucursal (el sistema maneja más de una sucursal)
Habitación (pertenece a una sucursal, tiene tipo, precio y disponibilidad)
Reserva (asociada a un huésped, una habitación y un rango de fechas)
Usuario (con rol asignado)
Quiero que la arquitectura respete el enfoque N-Capas que hemos visto en clase (Presentación / Lógica de Negocio / Acceso a Datos, como mínimo).  esto como una estructura inicial, luego tendra uso de jwt. primero dame esto que te pido


para estructura principal del proyecto, se corrgio uso de lombok, role, enums y se agrego las relaciones de hoteles con usuarios