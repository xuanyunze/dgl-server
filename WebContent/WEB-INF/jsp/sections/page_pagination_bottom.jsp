<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <div id="bottompagedivx" style="position:absolute;left:0;bottom:0;width:100%;">
       <table id="pagetablebottom" style="width:100%;">
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
         <td style="width:200px;" id="btnbottom">
          <span class="btn-batchdel">
           <span class="btn btn-default">
            <span class="btn-content">批量删除</span>
           </span>
          </span>
          <span id="bottomnew" class="btn-new">
           <span class="btn btn-default">
            <span class="btn-content">新建</span>
           </span>
          </span>
         </td>
         <td style="text-align:right;float:right;">
          <table style="border:none;padding:0;margin:0;"><tr>
           <td id="bottomcontrol">
            <div class="page-control"></div>
           </td><td></td><td></td></tr>
          </table>
         </td>
         </tr>
        </table>
       </div>