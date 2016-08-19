<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="searchtable" style="width:100%;text-align:right;padding-right:10px;">
       <tr>
        <td id="crumbtd" style="text-align:left;width:35%" nowrap>
         <div style="float:left;margin:0 3px;cursor:pointer;width:20px;height:20px;" onclick="javascript:fnExpandTreeNav();">
          <a id="tree-toggle" style="width:20px;height:20px;" href="#"></a>
         </div>
         <div id="pagecrumb"></div>
        </td>
        <td style="width:65%;">
         <form id="searchform">
          <span class="search-condition" style="display:none;">
           <span class="styled-select">
            <select id="searchkeytype">
         	 <option value="index">全文检索</option>
         	 <option value="uid">用户ID</option>
         	 <option value="uname">用户姓名</option>
         	 <option value="uphone">用户手机</option>
         	</select>
           </span>
          </span>
          <div class="searchkey" style="display:none;">
           <input id="searchkey" name="searchkey" value="" />
           <span id="gosearch" onclick="fnDoSearch()"></span>
          </div>
          <div class="btn-group" style="float:right;">
           <a id="search" class="btn-search" onclick="fnDoSearch();return false;"style="margin-left:-5px;display:none;">
         	<strong>查询</strong>
           </a>
           <a id="comxsearch" class="btn-compxsearch" onclick="fnGoCompxSearch();return false;" style="margin-left:-8px">
         	<strong>开始查询</strong>
           </a>
           <a id="comxsearch" class="btn-compxsearch" onclick="fnClearSearch();return false;" style="margin-left:-8px">
         	<strong>清除查询</strong>
           </a>
          </div>
         </form>
        </td>
       </tr>
      </table>