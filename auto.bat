:loop

	cd C:\\Users\\82103\\Desktop\\취업\\알고리즘_문제풀이\\programmers_high_kit

    git remote remove origin

	git remote add origin git@github.com:myeongbaek/programmers_high_kit.git
	
	git push --set-upstream origin master

	git pull
	
	git add --all
	
	git commit -m "%date%"

	git push
	
	:: 3600초 대기
	TIMEOUT 3600
	
goto loop
