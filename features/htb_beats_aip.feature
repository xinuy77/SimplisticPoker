Feature: HTB beats AIP
	
	Scenario: HTB has RF beats API SF
		Given HTB draws card and API draws card
		When HTB has RF and API has SF
		Then HTB beats API