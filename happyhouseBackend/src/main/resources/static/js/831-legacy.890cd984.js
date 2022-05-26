"use strict";(self["webpackChunkhappyhouse"]=self["webpackChunkhappyhouse"]||[]).push([[831],{17831:function(e,s,t){t.r(s),t.d(s,{default:function(){return b}});var r=function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("b-container",{staticClass:"bv-example-row mt-3"},[t("div",{staticClass:"row justify-content-center"},[t("div",{staticClass:"col-lg-5 col-md-7"},[t("div",{staticClass:"card bg-secondary bg-white shadow border-0"},[t("div",{staticClass:"card-body px-lg-5 py-lg-5"},[t("div",{staticClass:"text-center text-muted mb-4"},[t("small",[e._v("sign up form")])]),t("b-form",{staticClass:"text-left"},[t("b-form-group",{attrs:{"label-for":"userid"}},[t("b-input-group",[t("b-input-group-prepend",[t("span",{staticClass:"input-group-text"},[t("b-icon",{attrs:{icon:"envelope"}})],1)]),t("b-form-input",{attrs:{id:"userid",disabled:"",placeholder:e.userInfo.userid},model:{value:e.user.userid,callback:function(s){e.$set(e.user,"userid",s)},expression:"user.userid"}})],1)],1),t("b-form-group",{attrs:{"label-for":"username"}},[t("b-input-group",[t("b-input-group-prepend",[t("span",{staticClass:"input-group-text"},[t("b-icon",{attrs:{icon:"people"}})],1)]),t("b-form-input",{attrs:{type:"text",id:"username",disabled:"",placeholder:e.userInfo.username},model:{value:e.user.username,callback:function(s){e.$set(e.user,"username",s)},expression:"user.username"}})],1)],1),t("b-form-group",{attrs:{"label-for":"email"}},[t("b-input-group",[t("b-input-group-prepend",[t("span",{staticClass:"input-group-text"},[t("b-icon",{attrs:{icon:"people"}})],1)]),t("b-form-input",{attrs:{type:"text",id:"email",required:"",placeholder:e.userInfo.email},model:{value:e.user.email,callback:function(s){e.$set(e.user,"email",s)},expression:"user.email"}})],1)],1),t("b-form-group",{attrs:{"label-for":"userpwd"}},[t("b-input-group",[t("b-input-group-prepend",[t("span",{staticClass:"input-group-text"},[t("b-icon",{attrs:{icon:"lock"}})],1)]),t("b-form-input",{attrs:{type:"password",id:"userpwd",required:"",placeholder:"Password"},model:{value:e.user.userpwd,callback:function(s){e.$set(e.user,"userpwd",s)},expression:"user.userpwd"}})],1)],1),t("b-form-group",{attrs:{"label-for":"pwdcheck"}},[t("b-input-group",[t("b-input-group-prepend",[t("span",{staticClass:"input-group-text"},[t("b-icon",{attrs:{icon:"lock-fill"}})],1)]),t("b-form-input",{attrs:{type:"password",id:"pwdcheck",required:"",placeholder:"Password check"},model:{value:e.user.pwdcheck,callback:function(s){e.$set(e.user,"pwdcheck",s)},expression:"user.pwdcheck"}})],1)],1),t("b-form-group",{attrs:{"label-for":"phone"}},[t("b-input-group",[t("b-input-group-prepend",[t("span",{staticClass:"input-group-text"},[t("b-icon",{attrs:{icon:"lock"}})],1)]),t("b-form-input",{attrs:{type:"text",id:"phone",required:"",placeholder:e.userInfo.phone},model:{value:e.user.phone,callback:function(s){e.$set(e.user,"phone",s)},expression:"user.phone"}})],1)],1),e._v(" 관심지역: "),t("b-row",{staticClass:"mt-4 mb-4 text-center"},[t("b-col",{staticClass:"sm-3"},[t("b-form-select",{attrs:{options:e.sidos},on:{change:e.gugunList},model:{value:e.sidoCode,callback:function(s){e.sidoCode=s},expression:"sidoCode"}})],1),t("b-col",{staticClass:"sm-3"},[t("b-form-select",{attrs:{options:e.guguns},on:{change:e.dongList},model:{value:e.gugunCode,callback:function(s){e.gugunCode=s},expression:"gugunCode"}})],1),t("b-col",{staticClass:"sm-3"},[t("b-form-select",{attrs:{options:e.dongs},model:{value:e.user.dongCode,callback:function(s){e.$set(e.user,"dongCode",s)},expression:"user.dongCode"}})],1)],1),t("div",{staticClass:"text-center"},[t("b-button",{staticClass:"btn btn-secondary m-1 font-weight-bold",attrs:{type:"button",variant:"secondary"},on:{click:e.confirm}},[e._v("수정완료")])],1)],1)],1)])])])])},u=[],o=t(16198),n=t(93019),i=(t(78975),t(92222),t(34665)),l="memberStore",a="houseStore",d={name:"MembderModify",data:function(){return{sidoCode:null,gugunCode:null,user:{userid:null,username:null,email:null,userpwd:null,pwdcheck:null,phone:null,dongCode:null,jibun:null}}},computed:(0,n.Z)((0,n.Z)({},(0,i.rn)(l,["userInfo","isLogin"])),(0,i.rn)(a,["sidos","guguns","dongs"])),created:function(){this.user=this.userInfo,this.userid=this.user.userid,this.username=this.user.username,this.email=this.user.email,this.phone=this.user.phone,this.getSido()},methods:(0,n.Z)((0,n.Z)((0,n.Z)((0,n.Z)({},(0,i.nv)(l,["setUserInfo"])),(0,i.nv)(a,["getSido","getGugun","getHouseList","getDong"])),(0,i.OI)(a,["CLEAR_SIDO_LIST","CLEAR_GUGUN_LIST","CLEAR_DONG_LIST"])),{},{gugunList:function(){console.log(this.sidoCode),this.CLEAR_GUGUN_LIST(),this.gugunCode=null,this.sidoCode&&this.getGugun(this.sidoCode)},dongList:function(){console.log(this.gugunCode),this.CLEAR_DONG_LIST(),this.dongCode=null,this.gugunCode&&this.getDong(this.gugunCode)},confirm:function(){var e=this;return(0,o.Z)(regeneratorRuntime.mark((function s(){var t,r,u,o,n,i;return regeneratorRuntime.wrap((function(s){while(1)switch(s.prev=s.next){case 0:if(null!=e.user.username&&null!=e.user.email&&null!=e.user.userpwd&&e.user.userpwd.length>=4&&e.user.userpwd==e.user.pwdcheck){for(t="",r=0;r<e.sidos.length;r++)e.sidos[r].value==e.sidoCode&&(t=e.sidos[r].text);for(u="",o=0;o<e.guguns.length;o++)e.guguns[o].value==e.gugunCode&&(u=e.guguns[o].text);for(n="",i=0;i<e.dongs.length;i++)e.dongs[i].value==e.user.dongCode&&(n=e.dongs[i].text);e.user.jibun="".concat(t," ").concat(u," ").concat(n),console.log(e.user.jibun),e.setUserInfo(e.user),alert("수정을 완료하였습니다."),e.$router.push({name:"mypage"})}else null==e.user.username?alert("이름을 입력해주세요."):null==e.user.email?alert("이메일을 입력해주세요."):null==e.user.userpwd?alert("비밀번호를 입력해주세요."):e.user.userpwd.length<4?alert("비밀번호를 4자리 이상 입력해주세요."):alert("modify fail");case 1:case"end":return s.stop()}}),s)})))()}})},p=d,c=t(1001),g=(0,c.Z)(p,r,u,!1,null,null,null),b=g.exports}}]);
//# sourceMappingURL=831-legacy.890cd984.js.map