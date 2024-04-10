Autor : Jorge Palacios 
     
# Sistema de Atención de Emergencias Hospitalarias

Este programa simula un sistema de atención de emergencias en un hospital. Permite la gestión de pacientes que llegan a la sección de emergencias y los coloca en una cola de prioridad según la gravedad de su situación.

## Descripción

El sistema utiliza una implementación de una cola con prioridad basada en un heap para ordenar a los pacientes según su código de emergencia, de la A a la E, donde A es la mayor prioridad y E la menor.

El programa lee los datos de los pacientes desde un archivo de texto (`pacientes.txt`) donde cada línea representa un paciente con su nombre, síntoma y código de emergencia, separados por comas. Luego, muestra el orden en que los pacientes serán atendidos uno a uno.

## Características

- Gestión eficiente de pacientes según la gravedad de su situación.
- Implementación de una cola con prioridad utilizando un heap.
- Lectura de datos de pacientes desde un archivo de texto.
- Interfaz simple y fácil de entender.


## Ejemplo de archivo pacientes.txt

- Juan Perez, fractura de pierna, C
- Maria Ramirez, apendicitis, A
- Lorenzo Toledo, chikunguya, E
- Carmen Sarmientos, dolores de parto, B

## Salida del programa 

Se adjunta imagen de la salida del programa utilizando el ejemplo del archivo

![Screenshot 2024-04-01 at 8 37 10 PM](https://github.com/Palasuwu/HDT8-AlgoritmosYEstructuraDeDatos/assets/134471477/c6a50fa1-ec6d-420e-bd52-3f095a52f949)

Notas: En la rama Main se encuentra la version del programa que NO contiene Java Collection Framework para el PriorityQueue , esta version se encontrara en otra rama del repositorio , llamada Java Framework Collection . 
