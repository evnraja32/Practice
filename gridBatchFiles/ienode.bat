java -Dwebdriver.ie.driver=".\..\drivers\IEDriverServer.exe" -jar selenium-server-standalone-3.8.0.jar -role node -hub http://192.168.23.139:4444/grid/register/ -port 1112 -browser browserName="internet explorer",maxInstances=5,version=8,platform=Windows, 