<#macro edit path="" >
<#if path=="/topic/create">
	<div class="panel-heading">
    	<ul class="nav nav-pills">
        	<li><a href="#">话题发布</a></li>
    	</ul>
	</div>
</#if>
	<div class="panel-body  paginate-bot">
	<div class="row">
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column">
		<form class="form-horizontal" role="form" action="${ctx}${path}" method="post" id="bbsform">
		<#if path=="/topic/create">
	  		<div class="form-group">
	    		<label for="title" >标题</label>
	    		<div>
	      			<input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
				</div>
	    		<label for="title" >版块</label>
	    		<div>
	      			<select class="form-control" id="tab" name="tab">
	      			<#list tabs as tab>
				      <option>${tab}</option>
				      </#list>
				    </select>
				</div>
	    		<label for="title" >标签</label>
	    		<div>
	      			<input type="text" class="form-control" id="tag" name="tag" placeholder="请输入标签">
				</div>
	  		</div>
	  		
	  		<div class="form-group">
	  		 	<label for="title" >发表主题</label>
	  	<#elseif path=="/reply/create">
	  	<div  class="form-group">
	  		<input type="hidden" class="form-control" id="topicUuid" name="topicUuid" value=${topic.uuid}>
	  		</div>
	  		<div class="form-group">
	  		 	<label for="title" >回复内容</label>
	  	</#if>
	  			
					<textarea  id="content" name="content" class="form-control" ></textarea>
	  		</div>
	  		
	  				<div id="summernote"></div>  
	 
		</form>  
	    		<div >
	      			<button id="bbsformButton" class="btn btn-default">&nbsp;&nbsp;发布&nbsp;&nbsp;</button>
	    		</div>
		</div>
		<div class="col-md-1 column">
		</div>
	</div>
</div>
<script>
$(function(){$('#content').css('display','none'); });

</script>	

</#macro>