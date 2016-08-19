<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      <table id="pagetabletop" style="width:100%;">
       <tr>
        <td style="width:90px;padding-left:20px;">
         <span onclick="javascript:selall();">
          <span class="btn btn-default">
           <span class="btn-content" style="padding:0 2px;">全选</span>
          </span>
         </span>
         <span onclick="javascript:deselall();">
          <span class="btn btn-default">
           <span class="btn-content" style="padding:0 2px;">反选</span>
          </span>
         </span>
        </td>
        <td style="width:200px;" id="btntop">
         <span class="btn-batchdel">
          <span class="btn btn-default">
           <span class="btn-content">批量删除</span>
          </span>
         </span>
         <span id="topnew" class="btn-new">
          <span class="btn btn-default">
           <span class="btn-content">新建</span>
          </span>
         </span>
        </td>
        <td style="text-align:right;float:right;">
		 <table style="border:none;padding:0;margin:0;"><tr>
		  <td id="topcontrol">
		   <div class="page-control"></div>
		  </td>
		  <td></td>
		  <td></td>
		 </tr></table>
        </td>
       </tr>
      </table>