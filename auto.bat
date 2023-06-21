:loop

	cd C:\Users\82103\Desktop\취업\알고리즘_문제풀이\programmers_high_kit

	git init
	
	git pull
	
	git add --all
	
	git commit -m "%date%"
	
	git push
	
	:: 3600초 대기
	TIMEOUT 3600
	
goto loop