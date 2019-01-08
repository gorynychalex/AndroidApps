Android 2D Графика 

https://developer.android.com/training/custom-views/custom-drawing#java

https://startandroid.ru/ru/uroki/vse-uroki-spiskom/311-urok-141-risovanie-dostup-k-canvas.html


Пакет android.graphics имеет все необходимые библиотеки для работы с двухмерной графикой.

Состоит из 2-х частей:
 - Canvas - что рисовать 
 - Paint - как рисовать

Для рисования простой графики, которая не будет динамически изменяться во время работы приложения, обычно используют класс, наследующий от View и задействуют метод onDraw().

В метод передается объект Canvas, у которого есть различные графические методы.
   
   