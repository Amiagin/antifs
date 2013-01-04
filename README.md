antifs
======

Custom ant tasks (C preprocessor-like ifs)

if:
    <if arg1="" arg2="" ignorecase="true">
        <isequal>
        </isequal>
        <else>
        </else>
    </if>
    
ifdef:
    <ifdef property="">
        <then>
        </then>
        <else>
        </else>
    </ifdef>
    
ifndef:
    <ifndef property="">
        <then>
        </then>
        <else>
        </else>
    </ifndef>

ifexist:
    <ifexist file="">
        <then>
        </then>
        <else>
        </else>
    </ifexist>

tolowercase:
    <tolowercase property=""/>
        
touppercase:
    <touppercase property=""/>
