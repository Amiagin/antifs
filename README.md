antifs
======

Custom ant task

touppercase
    <touppercase property="some.property"/>
	
tolowercase
    <tolowercase property="some.property"/>
	
switch/case
		<switch input="foo">
		    <case value="f00">
			    <echo message="f00"/>
				<echo message="Yeah!"/>
			</case>
			<case value="f99">
			    <echo message="f99"/>                
				<echo message="Yeah!"/>
			</case>
			<case value="foo">
			    <echo message="foo"/>
				<echo message="Yeah!"/>
			</case>
			<default>
			    <echo message="default executed"/>
			</default>
		</switch>
		
ifndef
ifexist
if/elseif/else
ifdef

