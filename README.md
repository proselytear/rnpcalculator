#CLI RPN Calculator

###Implemented a command-line reverse polish notation (RPN) calculator using a language that you know well.

### Description of application

Application has 3 layers:<br/>
    - <b>view</b> - console view for users that could be easily replaced by web page, REST, etc.<br/>
    - <b>controller</b> - IO controller that handles data received from view layer (could be replaced with WEB Controller, Socket, REST controller, etc.)<br/>
    - <b>service</b> - business logic for calculating result of input<br/>

Added CalculatorIOException that should handle any error occurred via program work.<br/>

## Environment
1. JDK 8+
2. Maven 3+

## Run application
1. git clone https://github.com/proselytear/rnpcalculator
2. Open project or go to project directory using command line
3. 
    Run class RnpCalculatorApplication
    
    OR
    
    Execute command line commands:
    - mvn clean install
    - mvn exec:java -D"exec.mainClass"="net.proselyte.rnpcalculator.RnpCalculatorApplication"
 
4. For exit enter 'q' and push ENTER or CTRL+D


##  Application in work

1. Enter number and press ENTER
2. Enter any amount of numbers
3. Enter operator symbol and press ENTER
   Supported operators: +, -, *, /, %
   
Example:

>1<br>
>2<br>
>3<br>
>\+<br>
>6.0

4. Enter 'q' and press ENTER for exit