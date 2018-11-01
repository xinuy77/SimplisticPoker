Feature: Detects hand in any order
	
	Scenario: Detect RF in any order
		Given Initialize game by list of RF permutation
		|Hand|
		|	SA	SK	SQ	SJ	S10	|
		|	SK	SA	SQ	SJ	S10	|
		|	SQ	SA	SK	SJ	S10	|
		|	SA	SQ	SK	SJ	S10	|
		|	SK	SQ	SA	SJ	S10	|
		|	SQ	SK	SA	SJ	S10	|
		|	SQ	SK	SJ	SA	S10	|
		|	SK	SQ	SJ	SA	S10	|
		|	SJ	SQ	SK	SA	S10	|
		|	SQ	SJ	SK	SA	S10	|
		|	SK	SJ	SQ	SA	S10	|
		|	SJ	SK	SQ	SA	S10	|
		|	SJ	SA	SQ	SK	S10	|
		|	SA	SJ	SQ	SK	S10	|
		|	SQ	SJ	SA	SK	S10	|
		|	SJ	SQ	SA	SK	S10	|
		|	SA	SQ	SJ	SK	S10	|
		|	SQ	SA	SJ	SK	S10	|
		|	SK	SA	SJ	SQ	S10	|
		|	SA	SK	SJ	SQ	S10	|
		|	SJ	SK	SA	SQ	S10	|
		|	SK	SJ	SA	SQ	S10	|
		|	SA	SJ	SK	SQ	S10	|
		|	SJ	SA	SK	SQ	S10	|
		|	S10	SA	SK	SQ	SJ	|
		|	SA	S10	SK	SQ	SJ	|
		|	SK	S10	SA	SQ	SJ	|
		|	S10	SK	SA	SQ	SJ	|
		|	SA	SK	S10	SQ	SJ	|
		|	SK	SA	S10	SQ	SJ	|
		|	SK	SA	SQ	S10	SJ	|
		|	SA	SK	SQ	S10	SJ	|
		|	SQ	SK	SA	S10	SJ	|
		|	SK	SQ	SA	S10	SJ	|
		|	SA	SQ	SK	S10	SJ	|
		|	SQ	SA	SK	S10	SJ	|
		|	SQ	S10	SK	SA	SJ	|
		|	S10	SQ	SK	SA	SJ	|
		|	SK	SQ	S10	SA	SJ	|
		|	SQ	SK	S10	SA	SJ	|
		|	S10	SK	SQ	SA	SJ	|
		|	SK	S10	SQ	SA	SJ	|
		|	SA	S10	SQ	SK	SJ	|
		|	S10	SA	SQ	SK	SJ	|
		|	SQ	SA	S10	SK	SJ	|
		|	SA	SQ	S10	SK	SJ	|
		|	S10	SQ	SA	SK	SJ	|
		|	SQ	S10	SA	SK	SJ	|
		|	SJ	S10	SA	SK	SQ	|
		|	S10	SJ	SA	SK	SQ	|
		|	SA	SJ	S10	SK	SQ	|
		|	SJ	SA	S10	SK	SQ	|
		|	S10	SA	SJ	SK	SQ	|
		|	SA	S10	SJ	SK	SQ	|
		|	SA	S10	SK	SJ	SQ	|
		|	S10	SA	SK	SJ	SQ	|
		|	SK	SA	S10	SJ	SQ	|
		|	SA	SK	S10	SJ	SQ	|
		|	S10	SK	SA	SJ	SQ	|
		|	SK	S10	SA	SJ	SQ	|
		|	SK	SJ	SA	S10	SQ	|
		|	SJ	SK	SA	S10	SQ	|
		|	SA	SK	SJ	S10	SQ	|
		|	SK	SA	SJ	S10	SQ	|
		|	SJ	SA	SK	S10	SQ	|
		|	SA	SJ	SK	S10	SQ	|
		|	S10	SJ	SK	SA	SQ	|
		|	SJ	S10	SK	SA	SQ	|
		|	SK	S10	SJ	SA	SQ	|
		|	S10	SK	SJ	SA	SQ	|
		|	SJ	SK	S10	SA	SQ	|
		|	SK	SJ	S10	SA	SQ	|
		|	SQ	SJ	S10	SA	SK	|
		|	SJ	SQ	S10	SA	SK	|
		|	S10	SQ	SJ	SA	SK	|
		|	SQ	S10	SJ	SA	SK	|
		|	SJ	S10	SQ	SA	SK	|
		|	S10	SJ	SQ	SA	SK	|
		|	S10	SJ	SA	SQ	SK	|
		|	SJ	S10	SA	SQ	SK	|
		|	SA	S10	SJ	SQ	SK	|
		|	S10	SA	SJ	SQ	SK	|
		|	SJ	SA	S10	SQ	SK	|
		|	SA	SJ	S10	SQ	SK	|
		|	SA	SQ	S10	SJ	SK	|
		|	SQ	SA	S10	SJ	SK	|
		|	S10	SA	SQ	SJ	SK	|
		|	SA	S10	SQ	SJ	SK	|
		|	SQ	S10	SA	SJ	SK	|
		|	S10	SQ	SA	SJ	SK	|
		|	SJ	SQ	SA	S10	SK	|
		|	SQ	SJ	SA	S10	SK	|
		|	SA	SJ	SQ	S10	SK	|
		|	SJ	SA	SQ	S10	SK	|
		|	SQ	SA	SJ	S10	SK	|
		|	SA	SQ	SJ	S10	SK	|
		|	SK	SQ	SJ	S10	SA	|
		|	SQ	SK	SJ	S10	SA	|
		|	SJ	SK	SQ	S10	SA	|
		|	SK	SJ	SQ	S10	SA	|
		|	SQ	SJ	SK	S10	SA	|
		|	SJ	SQ	SK	S10	SA	|
		|	SJ	SQ	S10	SK	SA	|
		|	SQ	SJ	S10	SK	SA	|
		|	S10	SJ	SQ	SK	SA	|
		|	SJ	S10	SQ	SK	SA	|
		|	SQ	S10	SJ	SK	SA	|
		|	S10	SQ	SJ	SK	SA	|
		|	S10	SK	SJ	SQ	SA	|
		|	SK	S10	SJ	SQ	SA	|
		|	SJ	S10	SK	SQ	SA	|
		|	S10	SJ	SK	SQ	SA	|
		|	SK	SJ	S10	SQ	SA	|
		|	SJ	SK	S10	SQ	SA	|
		|	SQ	SK	S10	SJ	SA	|
		|	SK	SQ	S10	SJ	SA	|
		|	S10	SQ	SK	SJ	SA	|
		|	SQ	S10	SK	SJ	SA	|
		|	SK	S10	SQ	SJ	SA	|
		|	S10	SK	SQ	SJ	SA	|
		Then Game detects every RF
		
	Scenario: Detect SF in any order
		Given Initialize game by list of SF permutation
		|Hands|
		|	S8	S7	S6	S5	S4	|
		|	S7	S8	S6	S5	S4	|
		|	S6	S8	S7	S5	S4	|
		|	S8	S6	S7	S5	S4	|
		|	S7	S6	S8	S5	S4	|
		|	S6	S7	S8	S5	S4	|
		|	S6	S7	S5	S8	S4	|
		|	S7	S6	S5	S8	S4	|
		|	S5	S6	S7	S8	S4	|
		|	S6	S5	S7	S8	S4	|
		|	S7	S5	S6	S8	S4	|
		|	S5	S7	S6	S8	S4	|
		|	S5	S8	S6	S7	S4	|
		|	S8	S5	S6	S7	S4	|
		|	S6	S5	S8	S7	S4	|
		|	S5	S6	S8	S7	S4	|
		|	S8	S6	S5	S7	S4	|
		|	S6	S8	S5	S7	S4	|
		|	S7	S8	S5	S6	S4	|
		|	S8	S7	S5	S6	S4	|
		|	S5	S7	S8	S6	S4	|
		|	S7	S5	S8	S6	S4	|
		|	S8	S5	S7	S6	S4	|
		|	S5	S8	S7	S6	S4	|
		|	S4	S8	S7	S6	S5	|
		|	S8	S4	S7	S6	S5	|
		|	S7	S4	S8	S6	S5	|
		|	S4	S7	S8	S6	S5	|
		|	S8	S7	S4	S6	S5	|
		|	S7	S8	S4	S6	S5	|
		|	S7	S8	S6	S4	S5	|
		|	S8	S7	S6	S4	S5	|
		|	S6	S7	S8	S4	S5	|
		|	S7	S6	S8	S4	S5	|
		|	S8	S6	S7	S4	S5	|
		|	S6	S8	S7	S4	S5	|
		|	S6	S4	S7	S8	S5	|
		|	S4	S6	S7	S8	S5	|
		|	S7	S6	S4	S8	S5	|
		|	S6	S7	S4	S8	S5	|
		|	S4	S7	S6	S8	S5	|
		|	S7	S4	S6	S8	S5	|
		|	S8	S4	S6	S7	S5	|
		|	S4	S8	S6	S7	S5	|
		|	S6	S8	S4	S7	S5	|
		|	S8	S6	S4	S7	S5	|
		|	S4	S6	S8	S7	S5	|
		|	S6	S4	S8	S7	S5	|
		|	S5	S4	S8	S7	S6	|
		|	S4	S5	S8	S7	S6	|
		|	S8	S5	S4	S7	S6	|
		|	S5	S8	S4	S7	S6	|
		|	S4	S8	S5	S7	S6	|
		|	S8	S4	S5	S7	S6	|
		|	S8	S4	S7	S5	S6	|
		|	S4	S8	S7	S5	S6	|
		|	S7	S8	S4	S5	S6	|
		|	S8	S7	S4	S5	S6	|
		|	S4	S7	S8	S5	S6	|
		|	S7	S4	S8	S5	S6	|
		|	S7	S5	S8	S4	S6	|
		|	S5	S7	S8	S4	S6	|
		|	S8	S7	S5	S4	S6	|
		|	S7	S8	S5	S4	S6	|
		|	S5	S8	S7	S4	S6	|
		|	S8	S5	S7	S4	S6	|
		|	S4	S5	S7	S8	S6	|
		|	S5	S4	S7	S8	S6	|
		|	S7	S4	S5	S8	S6	|
		|	S4	S7	S5	S8	S6	|
		|	S5	S7	S4	S8	S6	|
		|	S7	S5	S4	S8	S6	|
		|	S6	S5	S4	S8	S7	|
		|	S5	S6	S4	S8	S7	|
		|	S4	S6	S5	S8	S7	|
		|	S6	S4	S5	S8	S7	|
		|	S5	S4	S6	S8	S7	|
		|	S4	S5	S6	S8	S7	|
		|	S4	S5	S8	S6	S7	|
		|	S5	S4	S8	S6	S7	|
		|	S8	S4	S5	S6	S7	|
		|	S4	S8	S5	S6	S7	|
		|	S5	S8	S4	S6	S7	|
		|	S8	S5	S4	S6	S7	|
		|	S8	S6	S4	S5	S7	|
		|	S6	S8	S4	S5	S7	|
		|	S4	S8	S6	S5	S7	|
		|	S8	S4	S6	S5	S7	|
		|	S6	S4	S8	S5	S7	|
		|	S4	S6	S8	S5	S7	|
		|	S5	S6	S8	S4	S7	|
		|	S6	S5	S8	S4	S7	|
		|	S8	S5	S6	S4	S7	|
		|	S5	S8	S6	S4	S7	|
		|	S6	S8	S5	S4	S7	|
		|	S8	S6	S5	S4	S7	|
		|	S7	S6	S5	S4	S8	|
		|	S6	S7	S5	S4	S8	|
		|	S5	S7	S6	S4	S8	|
		|	S7	S5	S6	S4	S8	|
		|	S6	S5	S7	S4	S8	|
		|	S5	S6	S7	S4	S8	|
		|	S5	S6	S4	S7	S8	|
		|	S6	S5	S4	S7	S8	|
		|	S4	S5	S6	S7	S8	|
		|	S5	S4	S6	S7	S8	|
		|	S6	S4	S5	S7	S8	|
		|	S4	S6	S5	S7	S8	|
		|	S4	S7	S5	S6	S8	|
		|	S7	S4	S5	S6	S8	|
		|	S5	S4	S7	S6	S8	|
		|	S4	S5	S7	S6	S8	|
		|	S7	S5	S4	S6	S8	|
		|	S5	S7	S4	S6	S8	|
		|	S6	S7	S4	S5	S8	|
		|	S7	S6	S4	S5	S8	|
		|	S4	S6	S7	S5	S8	|
		|	S6	S4	S7	S5	S8	|
		|	S7	S4	S6	S5	S8	|
		|	S4	S7	S6	S5	S8	|
		Then Game detects every SF
		
	Scenario: Detect FOK in any order
		Given Initialize game by list of FOK permutation
		|Hands|
		|	HJ	DJ	SJ	CJ	D7	|
		|	DJ	HJ	SJ	CJ	D7	|
		|	SJ	HJ	DJ	CJ	D7	|
		|	HJ	SJ	DJ	CJ	D7	|
		|	DJ	SJ	HJ	CJ	D7	|
		|	SJ	DJ	HJ	CJ	D7	|
		|	SJ	DJ	CJ	HJ	D7	|
		|	DJ	SJ	CJ	HJ	D7	|
		|	CJ	SJ	DJ	HJ	D7	|
		|	SJ	CJ	DJ	HJ	D7	|
		|	DJ	CJ	SJ	HJ	D7	|
		|	CJ	DJ	SJ	HJ	D7	|
		|	CJ	HJ	SJ	DJ	D7	|
		|	HJ	CJ	SJ	DJ	D7	|
		|	SJ	CJ	HJ	DJ	D7	|
		|	CJ	SJ	HJ	DJ	D7	|
		|	HJ	SJ	CJ	DJ	D7	|
		|	SJ	HJ	CJ	DJ	D7	|
		|	DJ	HJ	CJ	SJ	D7	|
		|	HJ	DJ	CJ	SJ	D7	|
		|	CJ	DJ	HJ	SJ	D7	|
		|	DJ	CJ	HJ	SJ	D7	|
		|	HJ	CJ	DJ	SJ	D7	|
		|	CJ	HJ	DJ	SJ	D7	|
		|	D7	HJ	DJ	SJ	CJ	|
		|	HJ	D7	DJ	SJ	CJ	|
		|	DJ	D7	HJ	SJ	CJ	|
		|	D7	DJ	HJ	SJ	CJ	|
		|	HJ	DJ	D7	SJ	CJ	|
		|	DJ	HJ	D7	SJ	CJ	|
		|	DJ	HJ	SJ	D7	CJ	|
		|	HJ	DJ	SJ	D7	CJ	|
		|	SJ	DJ	HJ	D7	CJ	|
		|	DJ	SJ	HJ	D7	CJ	|
		|	HJ	SJ	DJ	D7	CJ	|
		|	SJ	HJ	DJ	D7	CJ	|
		|	SJ	D7	DJ	HJ	CJ	|
		|	D7	SJ	DJ	HJ	CJ	|
		|	DJ	SJ	D7	HJ	CJ	|
		|	SJ	DJ	D7	HJ	CJ	|
		|	D7	DJ	SJ	HJ	CJ	|
		|	DJ	D7	SJ	HJ	CJ	|
		|	HJ	D7	SJ	DJ	CJ	|
		|	D7	HJ	SJ	DJ	CJ	|
		|	SJ	HJ	D7	DJ	CJ	|
		|	HJ	SJ	D7	DJ	CJ	|
		|	D7	SJ	HJ	DJ	CJ	|
		|	SJ	D7	HJ	DJ	CJ	|
		|	CJ	D7	HJ	DJ	SJ	|
		|	D7	CJ	HJ	DJ	SJ	|
		|	HJ	CJ	D7	DJ	SJ	|
		|	CJ	HJ	D7	DJ	SJ	|
		|	D7	HJ	CJ	DJ	SJ	|
		|	HJ	D7	CJ	DJ	SJ	|
		|	HJ	D7	DJ	CJ	SJ	|
		|	D7	HJ	DJ	CJ	SJ	|
		|	DJ	HJ	D7	CJ	SJ	|
		|	HJ	DJ	D7	CJ	SJ	|
		|	D7	DJ	HJ	CJ	SJ	|
		|	DJ	D7	HJ	CJ	SJ	|
		|	DJ	CJ	HJ	D7	SJ	|
		|	CJ	DJ	HJ	D7	SJ	|
		|	HJ	DJ	CJ	D7	SJ	|
		|	DJ	HJ	CJ	D7	SJ	|
		|	CJ	HJ	DJ	D7	SJ	|
		|	HJ	CJ	DJ	D7	SJ	|
		|	D7	CJ	DJ	HJ	SJ	|
		|	CJ	D7	DJ	HJ	SJ	|
		|	DJ	D7	CJ	HJ	SJ	|
		|	D7	DJ	CJ	HJ	SJ	|
		|	CJ	DJ	D7	HJ	SJ	|
		|	DJ	CJ	D7	HJ	SJ	|
		|	SJ	CJ	D7	HJ	DJ	|
		|	CJ	SJ	D7	HJ	DJ	|
		|	D7	SJ	CJ	HJ	DJ	|
		|	SJ	D7	CJ	HJ	DJ	|
		|	CJ	D7	SJ	HJ	DJ	|
		|	D7	CJ	SJ	HJ	DJ	|
		|	D7	CJ	HJ	SJ	DJ	|
		|	CJ	D7	HJ	SJ	DJ	|
		|	HJ	D7	CJ	SJ	DJ	|
		|	D7	HJ	CJ	SJ	DJ	|
		|	CJ	HJ	D7	SJ	DJ	|
		|	HJ	CJ	D7	SJ	DJ	|
		|	HJ	SJ	D7	CJ	DJ	|
		|	SJ	HJ	D7	CJ	DJ	|
		|	D7	HJ	SJ	CJ	DJ	|
		|	HJ	D7	SJ	CJ	DJ	|
		|	SJ	D7	HJ	CJ	DJ	|
		|	D7	SJ	HJ	CJ	DJ	|
		|	CJ	SJ	HJ	D7	DJ	|
		|	SJ	CJ	HJ	D7	DJ	|
		|	HJ	CJ	SJ	D7	DJ	|
		|	CJ	HJ	SJ	D7	DJ	|
		|	SJ	HJ	CJ	D7	DJ	|
		|	HJ	SJ	CJ	D7	DJ	|
		|	DJ	SJ	CJ	D7	HJ	|
		|	SJ	DJ	CJ	D7	HJ	|
		|	CJ	DJ	SJ	D7	HJ	|
		|	DJ	CJ	SJ	D7	HJ	|
		|	SJ	CJ	DJ	D7	HJ	|
		|	CJ	SJ	DJ	D7	HJ	|
		|	CJ	SJ	D7	DJ	HJ	|
		|	SJ	CJ	D7	DJ	HJ	|
		|	D7	CJ	SJ	DJ	HJ	|
		|	CJ	D7	SJ	DJ	HJ	|
		|	SJ	D7	CJ	DJ	HJ	|
		|	D7	SJ	CJ	DJ	HJ	|
		|	D7	DJ	CJ	SJ	HJ	|
		|	DJ	D7	CJ	SJ	HJ	|
		|	CJ	D7	DJ	SJ	HJ	|
		|	D7	CJ	DJ	SJ	HJ	|
		|	DJ	CJ	D7	SJ	HJ	|
		|	CJ	DJ	D7	SJ	HJ	|
		|	SJ	DJ	D7	CJ	HJ	|
		|	DJ	SJ	D7	CJ	HJ	|
		|	D7	SJ	DJ	CJ	HJ	|
		|	SJ	D7	DJ	CJ	HJ	|
		|	DJ	D7	SJ	CJ	HJ	|
		|	D7	DJ	SJ	CJ	HJ	|
		Then Game detects every FOK
	
	Scenario: Detect FH in any order
		Given Initialize game by list of FH permutation
		|Hands|
		|	H10	D10	S10	C9	D9	|
		|	D10	H10	S10	C9	D9	|
		|	S10	H10	D10	C9	D9	|
		|	H10	S10	D10	C9	D9	|
		|	D10	S10	H10	C9	D9	|
		|	S10	D10	H10	C9	D9	|
		|	S10	D10	C9	H10	D9	|
		|	D10	S10	C9	H10	D9	|
		|	C9	S10	D10	H10	D9	|
		|	S10	C9	D10	H10	D9	|
		|	D10	C9	S10	H10	D9	|
		|	C9	D10	S10	H10	D9	|
		|	C9	H10	S10	D10	D9	|
		|	H10	C9	S10	D10	D9	|
		|	S10	C9	H10	D10	D9	|
		|	C9	S10	H10	D10	D9	|
		|	H10	S10	C9	D10	D9	|
		|	S10	H10	C9	D10	D9	|
		|	D10	H10	C9	S10	D9	|
		|	H10	D10	C9	S10	D9	|
		|	C9	D10	H10	S10	D9	|
		|	D10	C9	H10	S10	D9	|
		|	H10	C9	D10	S10	D9	|
		|	C9	H10	D10	S10	D9	|
		|	D9	H10	D10	S10	C9	|
		|	H10	D9	D10	S10	C9	|
		|	D10	D9	H10	S10	C9	|
		|	D9	D10	H10	S10	C9	|
		|	H10	D10	D9	S10	C9	|
		|	D10	H10	D9	S10	C9	|
		|	D10	H10	S10	D9	C9	|
		|	H10	D10	S10	D9	C9	|
		|	S10	D10	H10	D9	C9	|
		|	D10	S10	H10	D9	C9	|
		|	H10	S10	D10	D9	C9	|
		|	S10	H10	D10	D9	C9	|
		|	S10	D9	D10	H10	C9	|
		|	D9	S10	D10	H10	C9	|
		|	D10	S10	D9	H10	C9	|
		|	S10	D10	D9	H10	C9	|
		|	D9	D10	S10	H10	C9	|
		|	D10	D9	S10	H10	C9	|
		|	H10	D9	S10	D10	C9	|
		|	D9	H10	S10	D10	C9	|
		|	S10	H10	D9	D10	C9	|
		|	H10	S10	D9	D10	C9	|
		|	D9	S10	H10	D10	C9	|
		|	S10	D9	H10	D10	C9	|
		|	C9	D9	H10	D10	S10	|
		|	D9	C9	H10	D10	S10	|
		|	H10	C9	D9	D10	S10	|
		|	C9	H10	D9	D10	S10	|
		|	D9	H10	C9	D10	S10	|
		|	H10	D9	C9	D10	S10	|
		|	H10	D9	D10	C9	S10	|
		|	D9	H10	D10	C9	S10	|
		|	D10	H10	D9	C9	S10	|
		|	H10	D10	D9	C9	S10	|
		|	D9	D10	H10	C9	S10	|
		|	D10	D9	H10	C9	S10	|
		|	D10	C9	H10	D9	S10	|
		|	C9	D10	H10	D9	S10	|
		|	H10	D10	C9	D9	S10	|
		|	D10	H10	C9	D9	S10	|
		|	C9	H10	D10	D9	S10	|
		|	H10	C9	D10	D9	S10	|
		|	D9	C9	D10	H10	S10	|
		|	C9	D9	D10	H10	S10	|
		|	D10	D9	C9	H10	S10	|
		|	D9	D10	C9	H10	S10	|
		|	C9	D10	D9	H10	S10	|
		|	D10	C9	D9	H10	S10	|
		|	S10	C9	D9	H10	D10	|
		|	C9	S10	D9	H10	D10	|
		|	D9	S10	C9	H10	D10	|
		|	S10	D9	C9	H10	D10	|
		|	C9	D9	S10	H10	D10	|
		|	D9	C9	S10	H10	D10	|
		|	D9	C9	H10	S10	D10	|
		|	C9	D9	H10	S10	D10	|
		|	H10	D9	C9	S10	D10	|
		|	D9	H10	C9	S10	D10	|
		|	C9	H10	D9	S10	D10	|
		|	H10	C9	D9	S10	D10	|
		|	H10	S10	D9	C9	D10	|
		|	S10	H10	D9	C9	D10	|
		|	D9	H10	S10	C9	D10	|
		|	H10	D9	S10	C9	D10	|
		|	S10	D9	H10	C9	D10	|
		|	D9	S10	H10	C9	D10	|
		|	C9	S10	H10	D9	D10	|
		|	S10	C9	H10	D9	D10	|
		|	H10	C9	S10	D9	D10	|
		|	C9	H10	S10	D9	D10	|
		|	S10	H10	C9	D9	D10	|
		|	H10	S10	C9	D9	D10	|
		|	D10	S10	C9	D9	H10	|
		|	S10	D10	C9	D9	H10	|
		|	C9	D10	S10	D9	H10	|
		|	D10	C9	S10	D9	H10	|
		|	S10	C9	D10	D9	H10	|
		|	C9	S10	D10	D9	H10	|
		|	C9	S10	D9	D10	H10	|
		|	S10	C9	D9	D10	H10	|
		|	D9	C9	S10	D10	H10	|
		|	C9	D9	S10	D10	H10	|
		|	S10	D9	C9	D10	H10	|
		|	D9	S10	C9	D10	H10	|
		|	D9	D10	C9	S10	H10	|
		|	D10	D9	C9	S10	H10	|
		|	C9	D9	D10	S10	H10	|
		|	D9	C9	D10	S10	H10	|
		|	D10	C9	D9	S10	H10	|
		|	C9	D10	D9	S10	H10	|
		|	S10	D10	D9	C9	H10	|
		|	D10	S10	D9	C9	H10	|
		|	D9	S10	D10	C9	H10	|
		|	S10	D9	D10	C9	H10	|
		|	D10	D9	S10	C9	H10	|
		|	D9	D10	S10	C9	H10	|
		Then Game detects every FH
	
	Scenario: Detect F in any order
		Given Initialize game by list of F permutation
		|Hands|
		|	S4	SJ	S8	S2	S9	|
		|	SJ	S4	S8	S2	S9	|
		|	S8	S4	SJ	S2	S9	|
		|	S4	S8	SJ	S2	S9	|
		|	SJ	S8	S4	S2	S9	|
		|	S8	SJ	S4	S2	S9	|
		|	S8	SJ	S2	S4	S9	|
		|	SJ	S8	S2	S4	S9	|
		|	S2	S8	SJ	S4	S9	|
		|	S8	S2	SJ	S4	S9	|
		|	SJ	S2	S8	S4	S9	|
		|	S2	SJ	S8	S4	S9	|
		|	S2	S4	S8	SJ	S9	|
		|	S4	S2	S8	SJ	S9	|
		|	S8	S2	S4	SJ	S9	|
		|	S2	S8	S4	SJ	S9	|
		|	S4	S8	S2	SJ	S9	|
		|	S8	S4	S2	SJ	S9	|
		|	SJ	S4	S2	S8	S9	|
		|	S4	SJ	S2	S8	S9	|
		|	S2	SJ	S4	S8	S9	|
		|	SJ	S2	S4	S8	S9	|
		|	S4	S2	SJ	S8	S9	|
		|	S2	S4	SJ	S8	S9	|
		|	S9	S4	SJ	S8	S2	|
		|	S4	S9	SJ	S8	S2	|
		|	SJ	S9	S4	S8	S2	|
		|	S9	SJ	S4	S8	S2	|
		|	S4	SJ	S9	S8	S2	|
		|	SJ	S4	S9	S8	S2	|
		|	SJ	S4	S8	S9	S2	|
		|	S4	SJ	S8	S9	S2	|
		|	S8	SJ	S4	S9	S2	|
		|	SJ	S8	S4	S9	S2	|
		|	S4	S8	SJ	S9	S2	|
		|	S8	S4	SJ	S9	S2	|
		|	S8	S9	SJ	S4	S2	|
		|	S9	S8	SJ	S4	S2	|
		|	SJ	S8	S9	S4	S2	|
		|	S8	SJ	S9	S4	S2	|
		|	S9	SJ	S8	S4	S2	|
		|	SJ	S9	S8	S4	S2	|
		|	S4	S9	S8	SJ	S2	|
		|	S9	S4	S8	SJ	S2	|
		|	S8	S4	S9	SJ	S2	|
		|	S4	S8	S9	SJ	S2	|
		|	S9	S8	S4	SJ	S2	|
		|	S8	S9	S4	SJ	S2	|
		|	S2	S9	S4	SJ	S8	|
		|	S9	S2	S4	SJ	S8	|
		|	S4	S2	S9	SJ	S8	|
		|	S2	S4	S9	SJ	S8	|
		|	S9	S4	S2	SJ	S8	|
		|	S4	S9	S2	SJ	S8	|
		|	S4	S9	SJ	S2	S8	|
		|	S9	S4	SJ	S2	S8	|
		|	SJ	S4	S9	S2	S8	|
		|	S4	SJ	S9	S2	S8	|
		|	S9	SJ	S4	S2	S8	|
		|	SJ	S9	S4	S2	S8	|
		|	SJ	S2	S4	S9	S8	|
		|	S2	SJ	S4	S9	S8	|
		|	S4	SJ	S2	S9	S8	|
		|	SJ	S4	S2	S9	S8	|
		|	S2	S4	SJ	S9	S8	|
		|	S4	S2	SJ	S9	S8	|
		|	S9	S2	SJ	S4	S8	|
		|	S2	S9	SJ	S4	S8	|
		|	SJ	S9	S2	S4	S8	|
		|	S9	SJ	S2	S4	S8	|
		|	S2	SJ	S9	S4	S8	|
		|	SJ	S2	S9	S4	S8	|
		|	S8	S2	S9	S4	SJ	|
		|	S2	S8	S9	S4	SJ	|
		|	S9	S8	S2	S4	SJ	|
		|	S8	S9	S2	S4	SJ	|
		|	S2	S9	S8	S4	SJ	|
		|	S9	S2	S8	S4	SJ	|
		|	S9	S2	S4	S8	SJ	|
		|	S2	S9	S4	S8	SJ	|
		|	S4	S9	S2	S8	SJ	|
		|	S9	S4	S2	S8	SJ	|
		|	S2	S4	S9	S8	SJ	|
		|	S4	S2	S9	S8	SJ	|
		|	S4	S8	S9	S2	SJ	|
		|	S8	S4	S9	S2	SJ	|
		|	S9	S4	S8	S2	SJ	|
		|	S4	S9	S8	S2	SJ	|
		|	S8	S9	S4	S2	SJ	|
		|	S9	S8	S4	S2	SJ	|
		|	S2	S8	S4	S9	SJ	|
		|	S8	S2	S4	S9	SJ	|
		|	S4	S2	S8	S9	SJ	|
		|	S2	S4	S8	S9	SJ	|
		|	S8	S4	S2	S9	SJ	|
		|	S4	S8	S2	S9	SJ	|
		|	SJ	S8	S2	S9	S4	|
		|	S8	SJ	S2	S9	S4	|
		|	S2	SJ	S8	S9	S4	|
		|	SJ	S2	S8	S9	S4	|
		|	S8	S2	SJ	S9	S4	|
		|	S2	S8	SJ	S9	S4	|
		|	S2	S8	S9	SJ	S4	|
		|	S8	S2	S9	SJ	S4	|
		|	S9	S2	S8	SJ	S4	|
		|	S2	S9	S8	SJ	S4	|
		|	S8	S9	S2	SJ	S4	|
		|	S9	S8	S2	SJ	S4	|
		|	S9	SJ	S2	S8	S4	|
		|	SJ	S9	S2	S8	S4	|
		|	S2	S9	SJ	S8	S4	|
		|	S9	S2	SJ	S8	S4	|
		|	SJ	S2	S9	S8	S4	|
		|	S2	SJ	S9	S8	S4	|
		|	S8	SJ	S9	S2	S4	|
		|	SJ	S8	S9	S2	S4	|
		|	S9	S8	SJ	S2	S4	|
		|	S8	S9	SJ	S2	S4	|
		|	SJ	S9	S8	S2	S4	|
		|	S9	SJ	S8	S2	S4	|
		Then Game detects every F
		
	Scenario: Detect S in any order
		Given Initialize game by list of S permutation
		|Hands|
		|	C9	D8	S7	D6	H5	|
		|	D8	C9	S7	D6	H5	|
		|	S7	C9	D8	D6	H5	|
		|	C9	S7	D8	D6	H5	|
		|	D8	S7	C9	D6	H5	|
		|	S7	D8	C9	D6	H5	|
		|	S7	D8	D6	C9	H5	|
		|	D8	S7	D6	C9	H5	|
		|	D6	S7	D8	C9	H5	|
		|	S7	D6	D8	C9	H5	|
		|	D8	D6	S7	C9	H5	|
		|	D6	D8	S7	C9	H5	|
		|	D6	C9	S7	D8	H5	|
		|	C9	D6	S7	D8	H5	|
		|	S7	D6	C9	D8	H5	|
		|	D6	S7	C9	D8	H5	|
		|	C9	S7	D6	D8	H5	|
		|	S7	C9	D6	D8	H5	|
		|	D8	C9	D6	S7	H5	|
		|	C9	D8	D6	S7	H5	|
		|	D6	D8	C9	S7	H5	|
		|	D8	D6	C9	S7	H5	|
		|	C9	D6	D8	S7	H5	|
		|	D6	C9	D8	S7	H5	|
		|	H5	C9	D8	S7	D6	|
		|	C9	H5	D8	S7	D6	|
		|	D8	H5	C9	S7	D6	|
		|	H5	D8	C9	S7	D6	|
		|	C9	D8	H5	S7	D6	|
		|	D8	C9	H5	S7	D6	|
		|	D8	C9	S7	H5	D6	|
		|	C9	D8	S7	H5	D6	|
		|	S7	D8	C9	H5	D6	|
		|	D8	S7	C9	H5	D6	|
		|	C9	S7	D8	H5	D6	|
		|	S7	C9	D8	H5	D6	|
		|	S7	H5	D8	C9	D6	|
		|	H5	S7	D8	C9	D6	|
		|	D8	S7	H5	C9	D6	|
		|	S7	D8	H5	C9	D6	|
		|	H5	D8	S7	C9	D6	|
		|	D8	H5	S7	C9	D6	|
		|	C9	H5	S7	D8	D6	|
		|	H5	C9	S7	D8	D6	|
		|	S7	C9	H5	D8	D6	|
		|	C9	S7	H5	D8	D6	|
		|	H5	S7	C9	D8	D6	|
		|	S7	H5	C9	D8	D6	|
		|	D6	H5	C9	D8	S7	|
		|	H5	D6	C9	D8	S7	|
		|	C9	D6	H5	D8	S7	|
		|	D6	C9	H5	D8	S7	|
		|	H5	C9	D6	D8	S7	|
		|	C9	H5	D6	D8	S7	|
		|	C9	H5	D8	D6	S7	|
		|	H5	C9	D8	D6	S7	|
		|	D8	C9	H5	D6	S7	|
		|	C9	D8	H5	D6	S7	|
		|	H5	D8	C9	D6	S7	|
		|	D8	H5	C9	D6	S7	|
		|	D8	D6	C9	H5	S7	|
		|	D6	D8	C9	H5	S7	|
		|	C9	D8	D6	H5	S7	|
		|	D8	C9	D6	H5	S7	|
		|	D6	C9	D8	H5	S7	|
		|	C9	D6	D8	H5	S7	|
		|	H5	D6	D8	C9	S7	|
		|	D6	H5	D8	C9	S7	|
		|	D8	H5	D6	C9	S7	|
		|	H5	D8	D6	C9	S7	|
		|	D6	D8	H5	C9	S7	|
		|	D8	D6	H5	C9	S7	|
		|	S7	D6	H5	C9	D8	|
		|	D6	S7	H5	C9	D8	|
		|	H5	S7	D6	C9	D8	|
		|	S7	H5	D6	C9	D8	|
		|	D6	H5	S7	C9	D8	|
		|	H5	D6	S7	C9	D8	|
		|	H5	D6	C9	S7	D8	|
		|	D6	H5	C9	S7	D8	|
		|	C9	H5	D6	S7	D8	|
		|	H5	C9	D6	S7	D8	|
		|	D6	C9	H5	S7	D8	|
		|	C9	D6	H5	S7	D8	|
		|	C9	S7	H5	D6	D8	|
		|	S7	C9	H5	D6	D8	|
		|	H5	C9	S7	D6	D8	|
		|	C9	H5	S7	D6	D8	|
		|	S7	H5	C9	D6	D8	|
		|	H5	S7	C9	D6	D8	|
		|	D6	S7	C9	H5	D8	|
		|	S7	D6	C9	H5	D8	|
		|	C9	D6	S7	H5	D8	|
		|	D6	C9	S7	H5	D8	|
		|	S7	C9	D6	H5	D8	|
		|	C9	S7	D6	H5	D8	|
		|	D8	S7	D6	H5	C9	|
		|	S7	D8	D6	H5	C9	|
		|	D6	D8	S7	H5	C9	|
		|	D8	D6	S7	H5	C9	|
		|	S7	D6	D8	H5	C9	|
		|	D6	S7	D8	H5	C9	|
		|	D6	S7	H5	D8	C9	|
		|	S7	D6	H5	D8	C9	|
		|	H5	D6	S7	D8	C9	|
		|	D6	H5	S7	D8	C9	|
		|	S7	H5	D6	D8	C9	|
		|	H5	S7	D6	D8	C9	|
		|	H5	D8	D6	S7	C9	|
		|	D8	H5	D6	S7	C9	|
		|	D6	H5	D8	S7	C9	|
		|	H5	D6	D8	S7	C9	|
		|	D8	D6	H5	S7	C9	|
		|	D6	D8	H5	S7	C9	|
		|	S7	D8	H5	D6	C9	|
		|	D8	S7	H5	D6	C9	|
		|	H5	S7	D8	D6	C9	|
		|	S7	H5	D8	D6	C9	|
		|	D8	H5	S7	D6	C9	|
		|	H5	D8	S7	D6	C9	|
		Then Game detects every S
		
	Scenario: Detect TOK in any order
		Given Initialize game by list of TOK permutation
		|Hands|
		|	S7	D7	C7	CK	D3	|
		|	D7	S7	C7	CK	D3	|
		|	C7	S7	D7	CK	D3	|
		|	S7	C7	D7	CK	D3	|
		|	D7	C7	S7	CK	D3	|
		|	C7	D7	S7	CK	D3	|
		|	C7	D7	CK	S7	D3	|
		|	D7	C7	CK	S7	D3	|
		|	CK	C7	D7	S7	D3	|
		|	C7	CK	D7	S7	D3	|
		|	D7	CK	C7	S7	D3	|
		|	CK	D7	C7	S7	D3	|
		|	CK	S7	C7	D7	D3	|
		|	S7	CK	C7	D7	D3	|
		|	C7	CK	S7	D7	D3	|
		|	CK	C7	S7	D7	D3	|
		|	S7	C7	CK	D7	D3	|
		|	C7	S7	CK	D7	D3	|
		|	D7	S7	CK	C7	D3	|
		|	S7	D7	CK	C7	D3	|
		|	CK	D7	S7	C7	D3	|
		|	D7	CK	S7	C7	D3	|
		|	S7	CK	D7	C7	D3	|
		|	CK	S7	D7	C7	D3	|
		|	D3	S7	D7	C7	CK	|
		|	S7	D3	D7	C7	CK	|
		|	D7	D3	S7	C7	CK	|
		|	D3	D7	S7	C7	CK	|
		|	S7	D7	D3	C7	CK	|
		|	D7	S7	D3	C7	CK	|
		|	D7	S7	C7	D3	CK	|
		|	S7	D7	C7	D3	CK	|
		|	C7	D7	S7	D3	CK	|
		|	D7	C7	S7	D3	CK	|
		|	S7	C7	D7	D3	CK	|
		|	C7	S7	D7	D3	CK	|
		|	C7	D3	D7	S7	CK	|
		|	D3	C7	D7	S7	CK	|
		|	D7	C7	D3	S7	CK	|
		|	C7	D7	D3	S7	CK	|
		|	D3	D7	C7	S7	CK	|
		|	D7	D3	C7	S7	CK	|
		|	S7	D3	C7	D7	CK	|
		|	D3	S7	C7	D7	CK	|
		|	C7	S7	D3	D7	CK	|
		|	S7	C7	D3	D7	CK	|
		|	D3	C7	S7	D7	CK	|
		|	C7	D3	S7	D7	CK	|
		|	CK	D3	S7	D7	C7	|
		|	D3	CK	S7	D7	C7	|
		|	S7	CK	D3	D7	C7	|
		|	CK	S7	D3	D7	C7	|
		|	D3	S7	CK	D7	C7	|
		|	S7	D3	CK	D7	C7	|
		|	S7	D3	D7	CK	C7	|
		|	D3	S7	D7	CK	C7	|
		|	D7	S7	D3	CK	C7	|
		|	S7	D7	D3	CK	C7	|
		|	D3	D7	S7	CK	C7	|
		|	D7	D3	S7	CK	C7	|
		|	D7	CK	S7	D3	C7	|
		|	CK	D7	S7	D3	C7	|
		|	S7	D7	CK	D3	C7	|
		|	D7	S7	CK	D3	C7	|
		|	CK	S7	D7	D3	C7	|
		|	S7	CK	D7	D3	C7	|
		|	D3	CK	D7	S7	C7	|
		|	CK	D3	D7	S7	C7	|
		|	D7	D3	CK	S7	C7	|
		|	D3	D7	CK	S7	C7	|
		|	CK	D7	D3	S7	C7	|
		|	D7	CK	D3	S7	C7	|
		|	C7	CK	D3	S7	D7	|
		|	CK	C7	D3	S7	D7	|
		|	D3	C7	CK	S7	D7	|
		|	C7	D3	CK	S7	D7	|
		|	CK	D3	C7	S7	D7	|
		|	D3	CK	C7	S7	D7	|
		|	D3	CK	S7	C7	D7	|
		|	CK	D3	S7	C7	D7	|
		|	S7	D3	CK	C7	D7	|
		|	D3	S7	CK	C7	D7	|
		|	CK	S7	D3	C7	D7	|
		|	S7	CK	D3	C7	D7	|
		|	S7	C7	D3	CK	D7	|
		|	C7	S7	D3	CK	D7	|
		|	D3	S7	C7	CK	D7	|
		|	S7	D3	C7	CK	D7	|
		|	C7	D3	S7	CK	D7	|
		|	D3	C7	S7	CK	D7	|
		|	CK	C7	S7	D3	D7	|
		|	C7	CK	S7	D3	D7	|
		|	S7	CK	C7	D3	D7	|
		|	CK	S7	C7	D3	D7	|
		|	C7	S7	CK	D3	D7	|
		|	S7	C7	CK	D3	D7	|
		|	D7	C7	CK	D3	S7	|
		|	C7	D7	CK	D3	S7	|
		|	CK	D7	C7	D3	S7	|
		|	D7	CK	C7	D3	S7	|
		|	C7	CK	D7	D3	S7	|
		|	CK	C7	D7	D3	S7	|
		|	CK	C7	D3	D7	S7	|
		|	C7	CK	D3	D7	S7	|
		|	D3	CK	C7	D7	S7	|
		|	CK	D3	C7	D7	S7	|
		|	C7	D3	CK	D7	S7	|
		|	D3	C7	CK	D7	S7	|
		|	D3	D7	CK	C7	S7	|
		|	D7	D3	CK	C7	S7	|
		|	CK	D3	D7	C7	S7	|
		|	D3	CK	D7	C7	S7	|
		|	D7	CK	D3	C7	S7	|
		|	CK	D7	D3	C7	S7	|
		|	C7	D7	D3	CK	S7	|
		|	D7	C7	D3	CK	S7	|
		|	D3	C7	D7	CK	S7	|
		|	C7	D3	D7	CK	S7	|
		|	D7	D3	C7	CK	S7	|
		|	D3	D7	C7	CK	S7	|
		Then Game detects every TOK
		
	Scenario: Detect TP in any order
		Given Initialize game by list of TP permutation
		|Hands|
		|	C4	S4	C3	D3	CQ	|
		|	S4	C4	C3	D3	CQ	|
		|	C3	C4	S4	D3	CQ	|
		|	C4	C3	S4	D3	CQ	|
		|	S4	C3	C4	D3	CQ	|
		|	C3	S4	C4	D3	CQ	|
		|	C3	S4	D3	C4	CQ	|
		|	S4	C3	D3	C4	CQ	|
		|	D3	C3	S4	C4	CQ	|
		|	C3	D3	S4	C4	CQ	|
		|	S4	D3	C3	C4	CQ	|
		|	D3	S4	C3	C4	CQ	|
		|	D3	C4	C3	S4	CQ	|
		|	C4	D3	C3	S4	CQ	|
		|	C3	D3	C4	S4	CQ	|
		|	D3	C3	C4	S4	CQ	|
		|	C4	C3	D3	S4	CQ	|
		|	C3	C4	D3	S4	CQ	|
		|	S4	C4	D3	C3	CQ	|
		|	C4	S4	D3	C3	CQ	|
		|	D3	S4	C4	C3	CQ	|
		|	S4	D3	C4	C3	CQ	|
		|	C4	D3	S4	C3	CQ	|
		|	D3	C4	S4	C3	CQ	|
		|	CQ	C4	S4	C3	D3	|
		|	C4	CQ	S4	C3	D3	|
		|	S4	CQ	C4	C3	D3	|
		|	CQ	S4	C4	C3	D3	|
		|	C4	S4	CQ	C3	D3	|
		|	S4	C4	CQ	C3	D3	|
		|	S4	C4	C3	CQ	D3	|
		|	C4	S4	C3	CQ	D3	|
		|	C3	S4	C4	CQ	D3	|
		|	S4	C3	C4	CQ	D3	|
		|	C4	C3	S4	CQ	D3	|
		|	C3	C4	S4	CQ	D3	|
		|	C3	CQ	S4	C4	D3	|
		|	CQ	C3	S4	C4	D3	|
		|	S4	C3	CQ	C4	D3	|
		|	C3	S4	CQ	C4	D3	|
		|	CQ	S4	C3	C4	D3	|
		|	S4	CQ	C3	C4	D3	|
		|	C4	CQ	C3	S4	D3	|
		|	CQ	C4	C3	S4	D3	|
		|	C3	C4	CQ	S4	D3	|
		|	C4	C3	CQ	S4	D3	|
		|	CQ	C3	C4	S4	D3	|
		|	C3	CQ	C4	S4	D3	|
		|	D3	CQ	C4	S4	C3	|
		|	CQ	D3	C4	S4	C3	|
		|	C4	D3	CQ	S4	C3	|
		|	D3	C4	CQ	S4	C3	|
		|	CQ	C4	D3	S4	C3	|
		|	C4	CQ	D3	S4	C3	|
		|	C4	CQ	S4	D3	C3	|
		|	CQ	C4	S4	D3	C3	|
		|	S4	C4	CQ	D3	C3	|
		|	C4	S4	CQ	D3	C3	|
		|	CQ	S4	C4	D3	C3	|
		|	S4	CQ	C4	D3	C3	|
		|	S4	D3	C4	CQ	C3	|
		|	D3	S4	C4	CQ	C3	|
		|	C4	S4	D3	CQ	C3	|
		|	S4	C4	D3	CQ	C3	|
		|	D3	C4	S4	CQ	C3	|
		|	C4	D3	S4	CQ	C3	|
		|	CQ	D3	S4	C4	C3	|
		|	D3	CQ	S4	C4	C3	|
		|	S4	CQ	D3	C4	C3	|
		|	CQ	S4	D3	C4	C3	|
		|	D3	S4	CQ	C4	C3	|
		|	S4	D3	CQ	C4	C3	|
		|	C3	D3	CQ	C4	S4	|
		|	D3	C3	CQ	C4	S4	|
		|	CQ	C3	D3	C4	S4	|
		|	C3	CQ	D3	C4	S4	|
		|	D3	CQ	C3	C4	S4	|
		|	CQ	D3	C3	C4	S4	|
		|	CQ	D3	C4	C3	S4	|
		|	D3	CQ	C4	C3	S4	|
		|	C4	CQ	D3	C3	S4	|
		|	CQ	C4	D3	C3	S4	|
		|	D3	C4	CQ	C3	S4	|
		|	C4	D3	CQ	C3	S4	|
		|	C4	C3	CQ	D3	S4	|
		|	C3	C4	CQ	D3	S4	|
		|	CQ	C4	C3	D3	S4	|
		|	C4	CQ	C3	D3	S4	|
		|	C3	CQ	C4	D3	S4	|
		|	CQ	C3	C4	D3	S4	|
		|	D3	C3	C4	CQ	S4	|
		|	C3	D3	C4	CQ	S4	|
		|	C4	D3	C3	CQ	S4	|
		|	D3	C4	C3	CQ	S4	|
		|	C3	C4	D3	CQ	S4	|
		|	C4	C3	D3	CQ	S4	|
		|	S4	C3	D3	CQ	C4	|
		|	C3	S4	D3	CQ	C4	|
		|	D3	S4	C3	CQ	C4	|
		|	S4	D3	C3	CQ	C4	|
		|	C3	D3	S4	CQ	C4	|
		|	D3	C3	S4	CQ	C4	|
		|	D3	C3	CQ	S4	C4	|
		|	C3	D3	CQ	S4	C4	|
		|	CQ	D3	C3	S4	C4	|
		|	D3	CQ	C3	S4	C4	|
		|	C3	CQ	D3	S4	C4	|
		|	CQ	C3	D3	S4	C4	|
		|	CQ	S4	D3	C3	C4	|
		|	S4	CQ	D3	C3	C4	|
		|	D3	CQ	S4	C3	C4	|
		|	CQ	D3	S4	C3	C4	|
		|	S4	D3	CQ	C3	C4	|
		|	D3	S4	CQ	C3	C4	|
		|	C3	S4	CQ	D3	C4	|
		|	S4	C3	CQ	D3	C4	|
		|	CQ	C3	S4	D3	C4	|
		|	C3	CQ	S4	D3	C4	|
		|	S4	CQ	C3	D3	C4	|
		|	CQ	S4	C3	D3	C4	|
		Then Game detects every TP
		
	Scenario: Detect OP in any order
		Given Initialize game by list of OP permutation
		|Hands|
		|	HA	DA	C8	S4	H7	|
		|	DA	HA	C8	S4	H7	|
		|	C8	HA	DA	S4	H7	|
		|	HA	C8	DA	S4	H7	|
		|	DA	C8	HA	S4	H7	|
		|	C8	DA	HA	S4	H7	|
		|	C8	DA	S4	HA	H7	|
		|	DA	C8	S4	HA	H7	|
		|	S4	C8	DA	HA	H7	|
		|	C8	S4	DA	HA	H7	|
		|	DA	S4	C8	HA	H7	|
		|	S4	DA	C8	HA	H7	|
		|	S4	HA	C8	DA	H7	|
		|	HA	S4	C8	DA	H7	|
		|	C8	S4	HA	DA	H7	|
		|	S4	C8	HA	DA	H7	|
		|	HA	C8	S4	DA	H7	|
		|	C8	HA	S4	DA	H7	|
		|	DA	HA	S4	C8	H7	|
		|	HA	DA	S4	C8	H7	|
		|	S4	DA	HA	C8	H7	|
		|	DA	S4	HA	C8	H7	|
		|	HA	S4	DA	C8	H7	|
		|	S4	HA	DA	C8	H7	|
		|	H7	HA	DA	C8	S4	|
		|	HA	H7	DA	C8	S4	|
		|	DA	H7	HA	C8	S4	|
		|	H7	DA	HA	C8	S4	|
		|	HA	DA	H7	C8	S4	|
		|	DA	HA	H7	C8	S4	|
		|	DA	HA	C8	H7	S4	|
		|	HA	DA	C8	H7	S4	|
		|	C8	DA	HA	H7	S4	|
		|	DA	C8	HA	H7	S4	|
		|	HA	C8	DA	H7	S4	|
		|	C8	HA	DA	H7	S4	|
		|	C8	H7	DA	HA	S4	|
		|	H7	C8	DA	HA	S4	|
		|	DA	C8	H7	HA	S4	|
		|	C8	DA	H7	HA	S4	|
		|	H7	DA	C8	HA	S4	|
		|	DA	H7	C8	HA	S4	|
		|	HA	H7	C8	DA	S4	|
		|	H7	HA	C8	DA	S4	|
		|	C8	HA	H7	DA	S4	|
		|	HA	C8	H7	DA	S4	|
		|	H7	C8	HA	DA	S4	|
		|	C8	H7	HA	DA	S4	|
		|	S4	H7	HA	DA	C8	|
		|	H7	S4	HA	DA	C8	|
		|	HA	S4	H7	DA	C8	|
		|	S4	HA	H7	DA	C8	|
		|	H7	HA	S4	DA	C8	|
		|	HA	H7	S4	DA	C8	|
		|	HA	H7	DA	S4	C8	|
		|	H7	HA	DA	S4	C8	|
		|	DA	HA	H7	S4	C8	|
		|	HA	DA	H7	S4	C8	|
		|	H7	DA	HA	S4	C8	|
		|	DA	H7	HA	S4	C8	|
		|	DA	S4	HA	H7	C8	|
		|	S4	DA	HA	H7	C8	|
		|	HA	DA	S4	H7	C8	|
		|	DA	HA	S4	H7	C8	|
		|	S4	HA	DA	H7	C8	|
		|	HA	S4	DA	H7	C8	|
		|	H7	S4	DA	HA	C8	|
		|	S4	H7	DA	HA	C8	|
		|	DA	H7	S4	HA	C8	|
		|	H7	DA	S4	HA	C8	|
		|	S4	DA	H7	HA	C8	|
		|	DA	S4	H7	HA	C8	|
		|	C8	S4	H7	HA	DA	|
		|	S4	C8	H7	HA	DA	|
		|	H7	C8	S4	HA	DA	|
		|	C8	H7	S4	HA	DA	|
		|	S4	H7	C8	HA	DA	|
		|	H7	S4	C8	HA	DA	|
		|	H7	S4	HA	C8	DA	|
		|	S4	H7	HA	C8	DA	|
		|	HA	H7	S4	C8	DA	|
		|	H7	HA	S4	C8	DA	|
		|	S4	HA	H7	C8	DA	|
		|	HA	S4	H7	C8	DA	|
		|	HA	C8	H7	S4	DA	|
		|	C8	HA	H7	S4	DA	|
		|	H7	HA	C8	S4	DA	|
		|	HA	H7	C8	S4	DA	|
		|	C8	H7	HA	S4	DA	|
		|	H7	C8	HA	S4	DA	|
		|	S4	C8	HA	H7	DA	|
		|	C8	S4	HA	H7	DA	|
		|	HA	S4	C8	H7	DA	|
		|	S4	HA	C8	H7	DA	|
		|	C8	HA	S4	H7	DA	|
		|	HA	C8	S4	H7	DA	|
		|	DA	C8	S4	H7	HA	|
		|	C8	DA	S4	H7	HA	|
		|	S4	DA	C8	H7	HA	|
		|	DA	S4	C8	H7	HA	|
		|	C8	S4	DA	H7	HA	|
		|	S4	C8	DA	H7	HA	|
		|	S4	C8	H7	DA	HA	|
		|	C8	S4	H7	DA	HA	|
		|	H7	S4	C8	DA	HA	|
		|	S4	H7	C8	DA	HA	|
		|	C8	H7	S4	DA	HA	|
		|	H7	C8	S4	DA	HA	|
		|	H7	DA	S4	C8	HA	|
		|	DA	H7	S4	C8	HA	|
		|	S4	H7	DA	C8	HA	|
		|	H7	S4	DA	C8	HA	|
		|	DA	S4	H7	C8	HA	|
		|	S4	DA	H7	C8	HA	|
		|	C8	DA	H7	S4	HA	|
		|	DA	C8	H7	S4	HA	|
		|	H7	C8	DA	S4	HA	|
		|	C8	H7	DA	S4	HA	|
		|	DA	H7	C8	S4	HA	|
		|	H7	DA	C8	S4	HA	|
		Then Game detects every OP