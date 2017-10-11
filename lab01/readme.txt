Banner reklamowy wyswietlajacy tekst;

applikacja = klasa z mainem (kilka w projekcie)

mozliwe kilka tablic

metody ma wywolywac manager

obiekt rejestrowany w rejestrze RMI
(bind rebind lookup)

rejestr dziala na hoscie/porcie (tym samym - localhost)
locateRegistry
createRegistry class

~~
  public int bindBillboard(IBillboard billboard) throws RemoteException; 
				- (namiastka bilbordu)


agencja wysyla adwerta

manager nadaje id
wklada i wyciaga ordery NA BILBORD (rmi)
ogloszenia na WSZYSTKIE tablice

~~~~~~~~~~~~~`
co ma klient:
	zglaszam zadanie
	usuwam zadanie
	
	manager ma gui:
		jakie sa dostepne tablice
		ile tablice maja slotow wolnych

		start / stop okreslonych tablic


1.Start managera
2.Uruchamianie tablicy
3.Tablica rejestrowana w rejestrze/menagerze (bind)\
4.Pojawia sie na liscie (jak wyrzucic to znika)


KLIENT:
druga apk (place order / remove order)


unicast...object
unicats..object.export 
					EXPORT OBIEKTU W MAINIE


https://docs.oracle.com/javase/8/docs/api/java/rmi/server/UnicastRemoteObject.html
https://docs.oracle.com/javase/8/docs/api/java/rmi/server/UnicastRemoteObject.html#exportObject-java.rmi.Remote-int-
https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html
https://netbeans.org/kb/docs/java/quickstart-gui.html
https://netbeans.org/kb/docs/java/quickstart-gui.html#previewing_form
http://tomasz.kubik.staff.iiar.pwr.wroc.pl/dydaktyka/Java/
