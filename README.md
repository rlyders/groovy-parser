# groovy-parser(Parrot)
[![Build Status](https://travis-ci.org/danielsun1106/groovy-parser.svg?branch=master)](https://travis-ci.org/danielsun1106/groovy-parser)
[![Coverage Status](https://coveralls.io/repos/github/danielsun1106/groovy-parser/badge.svg)](https://coveralls.io/github/danielsun1106/groovy-parser)
[![Java 8+](https://img.shields.io/badge/java-8+-4c7e9f.svg)](http://java.oracle.com)
[![Apache License 2](https://img.shields.io/badge/license-APL2-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)
[![Join the chat at https://gitter.im/groovy-parser/Lobby](https://badges.gitter.im/groovy-parser/Lobby.svg)](https://gitter.im/groovy-parser/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

The new parser(Parrot) can parse Groovy source code and construct the related AST, which is almost identical to the one generated by the old parser(except the corrected node position, e.g. line, column of node). Currently all features of Groovy are available. In addition, **the following new features have been added:**

* do-while loop, standard loop(e.g. `for(int i = 0, j = 10; i < j; i++, j--) {..}`)
* lambda expression(e.g. `stream.map(e -> e + 1)`)
* method reference and constructor reference
* try-with-resources(i.e. ARM)
* code block(i.e. `{..}`)
* array initializer of Java style(e.g. `new int[] {1, 2, 3}`)
* default method of interface
* new operators: identity operators(`===`, `!==`), elvis assignment(`?=`), `!in`, `!instanceof`
* safe index(e.g. `nullableVar?[1, 2]`)
* runtime groovydoc(i.e. groovydoc with `@Groovydoc`), groovydoc attached to AST node as metadata

**JVM system properties to control parsing:**

* `groovy.antlr4.cache.threshold`: how frequently to clear DFA cache(default: 50). **Notice:** The more frequently the DFA cache is cleared, the poorer parsing performance will be(you can not set the value that is less than the default value). But the DFA cache has to be cleared to avoid OutOfMemoryError's occurring. 
* `groovy.extract.doc.comment`: whether to collect groovydoc while parsing groovy source code(default: false)

*P.S. Parrot is based on the highly optimized version of antlr4(com.tunnelvisionlabs:antlr4), which is licensed under BSD. Since 20161103 Parrot has been contributed to Apache Groovy, but the project will be maintained as a lab to experiment new features for Groovy. You can find it at [the parrot branch of apache/groovy](https://github.com/apache/groovy/tree/parrot/subprojects/groovy-parser-antlr4).*

If you want to give it a try, make sure your machine have `JDK 8+` installed first, then follow the steps:

```
$ git clone https://github.com/danielsun1106/groovy-parser.git
$ cd groovy-parser
$ ./gradlew groovyConsole
```

Feel free to report any issue you found, and pull requests are always welcome.

```groovy                                                                                                                                                                 
                                                                                                    
                     ...                                                                            
                 .fLjtttttti.                                                                       
                ,fi,t;jtjjjji,                                                                      
                ::t, ;.i . :Lji.                                                                    
                ,GDD: ,.  ,tft ,:                                                                   
                DDEDi.   ,i:,;.LL;                                                                  
                EEEKEL, .:,;:.;#tL,                                                                 
               ;DEEWKKf..L.:; ;Wf:;:                                                                
               GDDKWKWKK.f.;.;..,.:i                                                                
               GGEWEWWWW;:Df:.:f: :t,                                                               
               LfKW#W#EWf. E. jLLL:ti                                                               
               GjKWWWWWEf.  .E:   Lf;,                                                              
               LtKKWWDWGj     LDDf.Lii                                                              
               GjKWW#W##j         GGi;,                                                             
               LfEWW####iD         fj;;                                                             
               jG##EWW,fK##         Gi;i                                                            
               fG###LDtDWKW.        .f;i:                                                           
               :L##W#EDGWW#,        .t,;;                                                           
                fWW##KDEWW#j         E;,;:                                                          
                LDKWDKKW#W#K,        Et,,;;                                                         
                ,tDEEWW#####D       .ELi,,;                                                         
                 ijDKD#####WK.      ;DEi;,,,                                                        
                  . GEGW###WG ..  .:DEKi;,,;,                                                       
                    iGDKWWKEt...  jGEEKLi,,;i:                                                      
                     :;GDEG:j#tfDDGEKEEft,,,,,:                                                     
                     .,jLW#WEDDDDDDEKEELt,,,,,;:                                                    
                      L#WDEDDDEEDEEKKEGfj,,,:i;,,                                                   
                      jGEGDDDDEEDEEEEEDft,,,,;,;fj                                                  
                      :DEDDDEEEEEEEKKDDjt,:,,,;,tit                                                 
                       GLDDDDGDDDEKEEGLi,::,,,iii,ij,                                               
                       LDEEEGGDDDEDDLfji,::::,;iiii;;i.                                             
                       GDLGfLDDDEDfjjti,,::::,,;ttiti,jLDL,                                         
                       GGELfLGGLjjtiti;,::,,,;;ijt,;;jfjtjKj                                        
                       tfLGfLGfjjjtii,,:::,;;tttttjjjjjtfttGDi                                      
                       iijjfjfjjtii;;::,::,tftttjjjjjjtttfii;Gi                                     
                       ,ijtittttjii;,,,,:;ititttjjtttttttiit;,LL;.                                  
                       :,ii,;;,:,,;;,,:,;jttjttLfjtttijtiii;ti;,D;;                                 
                       :,,;,,,:::,,,,::,itjttiijfitiijjttii;jt;ttD,;                                
                       :,,,:::,,,,:::,,tfjtttiifttiitttiiittjfDftiti;.                              
                       j:,,::::,,,,,:::jjftjtttjitiitffiiiiiiLLLji;i;i                              
                       L::,,,:,::::::::tjtjjjtttiiiittftii;ttiffjtti;ft                             
                       jf:,:,:,::::::,,iffftjtitttttiifjttittffjtGfitiji                            
                       ,f,,::::::,:,::,jjjfjtttjjtitjitttttiiiittjtfjiLti                           
                       .fL,:,::,::::::,tjjjjitttttijjtfttjttiiiitjtijtftt:                          
                        jLi:,::::::,,,,;LjfLtittittttfjtjttiiitiiiiitfttjtj                         
                         LL:::,::,:::,,;;ttjttjfitttttjtjiitiitjjjjjtjjjtLij                        
                         fG,::,,,,::,,,,;jtLjtfjjtttitjjjiiii;ttttjjtitfjtjit                       
                         :Lt:,,,,,,,::,;,;jtjGjjtiittitjttiiitfitttjLjijfLG;ftG                     
                          jfL:,,,,,,::,,,;fjjjjjjtjttitttttittfjjtttLjifjfjtLj#D.                   
                           fLt,,,,,,,,,,,;itjf,;tjjtttttitjttiijffjtGGtjLjtGftt#KG                  
                           jLG,,,,,,,,,,,;;fjji;iijtttttitjititjjjttjGLjjLtfLfiE#K:                 
                            jG:,,,,,,,,,,;;ttjittjtjffttttjtLfGLjjttiGGfjGjfLGjtEEWE.               
                             LLf,,,,,,,,,;;;fjLjtitjjftttjttfDLLjjjtjGGfLfGjLfLjjGLKED.             
                             tDG,,,,,,,,,;;;;jGfjttjjLjitftLGfLLLjfjjfGLLLLfjLLfttKGDDG             
                              LGL,,,,,,,,,;;;fLLfjjttjfLGLLLDfGLGfjfLfLLfGDLfLLEftLELDGDj           
                              :LDi,;,,,,,;,;;iLDLfjjjjLLDLLLGffGGLffLLfLfEDEfLELGjGfDDDLDi          
                               .LLG,,,,,,;,;;;fGLLLfjffLGGGLfDLLLGDDGLLfL#KEKK#GLLjLfWEWGGf         
                                ::Lf,,,,,,;;;iLLGfLLffffLDDDfLGLffGDDGLfD##WGE#GLffjLL##WGDj        
                                   tf,,,,,;,;;jLGGGLGGLLGGDDDGfLfffKDGDGDEK##LDGGLLfGGW##W#GG       
                                    :.,,,,;;;;tDLGEGGGGGLGDEEGLLffEWEEGGGDEW#LLDGGfLLGf##GDDG       
                                       ,;;;;;;iDDLGEGGGDDDDGEEGGGEDE#WKDGGDDEGLLGGGDDGGD###WWj      
                                        :;;;;;;G;iLDEDDDDEEEEKGGLGDGDK#DGGGLGDGDLGDDGGGLE#WKKD,     
                                         ,;;;;;L,ijGGEDDDDEKDKLGLGDEGGEDGGGGLGGGKGGDGGGLLDEEEEG     
                                          :;;;;;;;iiGDGDDDDKEKLLDGGGGGLGEDEDDEDDDGKLDDDDGt   ;.     
                                           ;,;;ii;i;fGGEDDEKWKjLLGGGGGGLDDGEDEDDDDDDGDDDGfE         
                                           ;;tiiitti;tGDDDDEKfjjGDDDLLDDDDDDDDKEEDDDEEDEWGGDEKj     
                                           ,;ittiit;,;jDDDEDKttjjffWDDGDEDDDEEEWEEEDEEEEEDDK#WWD    
                                           .;;itjff,,;iitDDDEittjjffLGKDDDDEDEDK#EEEEEEKKEDEK###ED  
                                            ;;;itj;,;;;iijjti;;tjjfLGGDEWEEEKKWKK#EEEEEKKDEKGGDW#WD:
                                            :;;iji,,,,,;i;t,;;;tjfLGDDEEEEKLLLfttGKKKKKWEGDDW##GDEKK
                                             ,;;t;,,:::,,,,,,,;iffGGDDGGGDKEf,itiiLDDEEDDEDGGGLE#GDK
                                             ;;;tj,,:::,,,,,; .:ffLfLLDfffKEGGi;iijEDKGGLfLfGffjGWWf
                                              ;ii,;,,,,,,,,,,    :ttfjfGfjDEGftftGDtDGDEKGGtjj.fjifK
                                              ;;i,,,,,::,::,.     . jfjLLfLDDfLfjLtDGEK#KGfLfEG  ;ji
                                              :i;,:::::,,.:,          tfftjLLEKEGGDfLfLGEDLjLjf,    
                                               i,,,::,,,  ,.           fLfjfffLLKKGLfffLLDGLjftG    
                                               :;,,,,,,   .            tLttiitfDGjGDEDfjLEDGGLLj;   
                                                ,,,:,,,                  L;tttjfGDjLDEDGLf#DDGLLLj  
                                                ,,:,,;                   LtitttjGDjjLGEDLjt#KDGLLLj;
                                                i,,,;,                    t. jttffEfjfGEEDjtj#EDLLGf
                          tjj.     ,         :. ;,,,i:                        jjjjGDjjLGDEDfff#GGGLL
                        ;DGLL,itifjt;j;;,:,,;:..:;;iEGiGGj                     :ffLG .jfGDDDELGG#EGG
                       iG, ,.ittttfjtti;:::;;j;;:ifL;tit;D;                     ,fLLi  ;fGDGDDDGf#DD
                       . :jfLtitiittitt;;;;;;iittt;i,;;.  G                       GEED    i  GDDGDLW
                         ,;tf    itijij;t,,,ii;ijiiti.i   j                        DKKL    .   f.jK#
                                             ........ .   .                       :;,:.     ..:i:tLG
                                                                                  ....    ...... ...
  .....                                                                                             
  .....  ......:. ...:                                            ... .   .... .... ...... .. ..... 
                                                                                                    

```