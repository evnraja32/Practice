java -jar ./../lib/selenium-server-standalone-2.52.0.jar -role node -hub http://192.168.23.1:4444/grid/register/ -port 1115 -browser browserName="chrome",maxInstances=5,platform=WIN10, -Dwebdriver.chrome.driver=".\..\drivers\chromedriver.exe"