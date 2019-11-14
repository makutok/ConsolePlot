MathDraw
========
Java library to draw math functions in any terminal for Java (8+).

Usage
-----
First `import MathDraw;`.

Then, declare a `MathDraw` object. There are various possible constructors:

```java
new MathDraw (double xLength, double yLength);
new MathDraw (double xLength, double xUnit, double yLength, double yUnit);
new MathDraw (double xMin, double xMax, double xUnit, double yMin, double yMax, double yUnit);
```
Let's start with the second one. The simplest way to draw a function is this:

```java
MathDraw md = new MathDraw(4, 0.03, 3, 0.1);

md.sine();
```
`md` will draw functions from `x=-2` to `x=2` and from `y=-1.5` to `y=1.5`.

Each character will represent `0.03x` and `0.1y`.

```
OUTPUT:                                      |
                                             |               ········
                                             |            ···        ···
                                             |          ··              ··
                                             |        ··                  ··
                                             |       ·                      ·
                                             |     ··                        ··
··                                           |    ·                            ·
  ·                                          |  ··                              ·
   ·                                         | ·                                 ··
    ·                                        |·                                    ·
—————··——————————————————————————————————————·——————————————————————————————————————·—————
       ·                                   ··|                                       ·
        ·                                 ·  |                                        ··
         ·                               ·   |                                          ·
          ··                           ··    |                                           ·
            ·                         ·      |
             ··                     ··       |
               ··                  ·         |
                 ··              ··          |
                   ···        ···            |
                      ········               |
                                             |

```

It comes with lots of pre-loaded functions to use them directly.

```
.sinus()	.linear(double)		.power(double)		.exponential()		.floor()
.cosinus()	.parabola()		.squareRoot()		.logarithmic()		.ceiling()
.tangent()	.hyperbola()		.root(double)		.absolute(int)
```

Your own functions
------------------
You can declare your own one-parameter functions and send them directly to the drawing object.

```java
class MyFunctions {
    public static int pow3 (int x) {
        return x*x*x;
    }
}

md.func(MyFunctions::pow3);
```
Or you can send them through lambda notation. This offer the posibility of drawing multi-parameter functions

```java
md.func(x -> x * x * x);
md.func(x -> 1 / x);
md.func(x -> Math.pow(Math.E, x));
```
So `md.func(MyFunctions::pow3);` and `md.func(x -> x * x * x);` will both have the same output

```
OUTPUT:                                      |                                 ·
                                             |                                ·
                                             |                               ·
                                             |                             ··
                                             |                            ·
                                             |                          ··
                                             |                         ·
                                             |                       ··
                                             |                    ···
                                             |                 ···
                                             |           ······
—————————————————————————————————························———————————————————————————————
                           ······            |
                        ···                  |
                      ··                     |
                    ··                       |
                  ··                         |
                ··                           |
               ·                             |
              ·                              |
            ··                               |
           ·                                 |
          ·                                  |
```

Coordinate axis options
-----------------------
To set the maximum and the minimum of the function representation modify `.Axis.min` and `.Axis.max`.

To configure the size of the representation modify `.Axis.unit`, which is the unit each character will represent.
You can do this though the constructor:

```java
MathDraw md = new MathDraw(-2, +2, 0.05, -1,5, +1,5, 0.09);
```
or though getters & setters:

```java
md.xAxis.setMin (double);
  .yAxis.setMax (double);
	.setLength (double);	// set min and max with half of the given length
	.setUnit (double);
```

Printing options
----------------
`MathDraw` objects can be set with the characters that will represent the function.

```java
md.setChFunc (char);
  .setChZero (char);
  .setChSpace (char);

md.xAxis.setChar (char);
  .yAxis.setChar (char);
```
`.setChFunc(char)` sets the representation character of the function.

More execution examples
-----------------------
```java
MathDraw md = new MathDraw(8, 0.09, 6, 0.2);
md.hyperbola();
```
```
OUTPUT:                                      |     ·
                                             |
                                             |      ·
                                             |       ·
                                             |        ··
                                             |          ··
                                             |            ····
                                             |                ······
                                             |                      ···············
                                             |                                     ········
—————————————————————————————————————————————+—————————————————————————————————————————————
·········                                    |
         ···············                     |
                        ······               |
                              ····           |
                                  ··         |
                                    ·        |
                                     ··      |
                                             |
                                       ·     |
                                        ·    |
```
```java
md.xAxis.setMin(-1);
md.xAxis.setMax(8);
md.logaritmic();
```
```
OUTPUT:     |
            |                                                                          ····
            |                                                            ··············
            |                                                 ···········
            |                                        ·········
            |                                 ·······
            |                           ······
            |                      ·····
            |                  ····
            |               ···
            |            ···
————————————+——————————··——————————————————————————————————————————————————————————————————
            |        ··
            |      ··
            |     ·
            |    ·
            |   ·
            |
            |  ·
            |
            | ·
            |
```

Cool, uh?

Contributing
------------
Pull requests are welcome. Also feel free to open an issue to discuss about what you would change.

License
-------
Copyright	(c)	2019	Miguel Bautista Pérez  
GPL license, you have a copy of it in the [license](https://gitlab.com/makuto/mathdraw/blob/master/LICENSE) file.

