<%@ page pageEncoding="utf-8" isELIgnored="false"  %>

<div style="text-align: center" id="aaa">
    <table>
        <tr>
            <td style="border:0;line-height: 30px;">
                <img src="${pageContext.request.contextPath}/${param.coverImg}" style="width:100px;height:130px;margin-top: 30px">
                <p>专辑名: ${param.title}</p>
                <p>作者: ${param.author}</p>
                <p>播音: ${param.broadCast}</p>
                <p>发布时间: ${param.p_date} </p>
                <p>内容简介: ${param.brief}</p>
            </td>
        </tr>
    </table>
</div>
