java -jar selenium-server-standalone-2.52.0.jar -role node -hub http://192.168.0.104:4444/grid/register/ -port 1115 -browser browserName="chrome",maxInstances=5,platform=WINDOWS, -Dwebdriver.chrome.driver="H:\SelBeginerGuide\drivers\chromedriver.exe"