/abc${'123'}def $a.b.c,d${->12}/
$/${-12}abc${'123'}def $a.b.c,d${->12}/$

def p1=/ab/
def p2=/a${c}b/
p3=/a${c}b/
p4=/a${c}b/*2
p5=!/a${c}b/
p6= ~/a${c}b/
p7=~/a${c}b/
p8==~/a${c}b/
p9=/a${c}b/ + /a${c}b/
p10=/ab/
p11=/ab/*2
p12=!/ab/
p13= ~/ab/
p14=~/ab/
p15==~/ab/
p16=/ab/ + /ab/
p17=/ab/ == /cd/
p18=/a${c}b/ == /c${f}d/
p19=/ab/ != /cd/
p20=/a${c}b/ != /c${f}d/
p27=1?:/cd/
p28=1?:/a${c}b/
p29=1>2?/ab/:/cd/
p30=1>2?/c${f}d/:/c${f}d/
p29=true?
        /ab/:
        /cd/
p30=true?
        /c${f}d/:
        /c${f}d/
p31=/A/ && /B/
p32=/a${b}/ && /c${d}/
p33=/A/ || /B/
p34=/a${b}/ || /c${d}/
p39=/$a/
p40=/^a+$/
p41=/$0+/
p42=/$2a+/
p43=/$$2a+/
p44=/^$|$|^$$2a+$/
p45=/
    hello, world!
/
p46=/hello\
world/
p47=/hello\
    \/
world/
p48=/^hello\
    \/$|^
world$/
