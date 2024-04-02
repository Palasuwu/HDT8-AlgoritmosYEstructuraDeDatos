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

Notas: En la rama Main se encuentra la version del programa que NO contiene Java Collection Framework para el PriorityQueue , esta version se encontrara en otra rama del repositorio: 

