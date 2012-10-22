  ________     ____         __  __ 
 / ___/ _ |   / __/______  / /_/ /_
/ /__/ __ |  _\ \/ __/ _ \/ __/ __/
\___/_/ |_| /___/\__/\___/\__/\__/ 

=== C.A. Scott Consulting Actuary ===

	    = Indemnify =

Build Instructions:
	
	Webstart:
		first run genwebstart.groovy
		> groovy genwebstart.groovy > Indemnify.jnlp
		Then run
		> ant clean && ant webstart
	One Jar:
		To compile the Single Jar
		> ant clean && ant onejar
	Windows Executable:
		To compile the One Jar Win32 Executable
		> ant clean && ant win
	
	To make the Full dist (Webstart, One Jar, ect..)
		Note: This Increses the build number.
		> ant clean && ant dist


Support: support@cascott.co.za
Phone: +27 (0) 11 787 4955
Web: http://cascott.co.za/
Address:
    264 Oak Avenue
    Ferndale
    Randburg
    2194
    Republic of South Africa

