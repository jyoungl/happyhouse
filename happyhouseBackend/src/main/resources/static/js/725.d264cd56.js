"use strict";(self["webpackChunkhappyhouse"]=self["webpackChunkhappyhouse"]||[]).push([[725],{3725:function(t,e,r){r.r(e),r.d(e,{default:function(){return u}});var s=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("b-container",{staticClass:"bv-example-row mt-3"},[r("b-row",[r("b-col",[r("b-alert",{attrs:{show:""}},[r("h3",[t._v("글작성")])])],1)],1),r("board-input-item",{attrs:{type:"register"}})],1)},i=[],a=r(1819),c={name:"BoardWrite",components:{BoardInputItem:a.Z}},n=c,o=r(1001),l=(0,o.Z)(n,s,i,!1,null,null,null),u=l.exports},1819:function(t,e,r){r.d(e,{Z:function(){return p}});var s=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("b-row",{staticClass:"mb-1"},[r("b-col",{staticStyle:{"text-align":"left"}},[r("b-form",{on:{submit:t.onSubmit,reset:t.onReset}},[r("b-form-group",{attrs:{id:"userid-group",label:"작성자:","label-for":"userid",description:"작성자를 입력하세요."}},[r("b-form-input",{attrs:{id:"userid",disabled:t.isUserid,type:"text",placeholder:t.userInfo.userid},model:{value:t.article.userid,callback:function(e){t.$set(t.article,"userid",e)},expression:"article.userid"}})],1),r("b-form-group",{attrs:{id:"subject-group",label:"제목:","label-for":"subject",description:"제목을 입력하세요."}},[r("b-form-input",{attrs:{id:"subject",type:"text",required:"",placeholder:"제목 입력..."},model:{value:t.article.subject,callback:function(e){t.$set(t.article,"subject",e)},expression:"article.subject"}})],1),r("b-form-group",{attrs:{id:"content-group",label:"내용:","label-for":"content"}},[r("b-form-textarea",{attrs:{id:"content",placeholder:"내용 입력...",rows:"10","max-rows":"15"},model:{value:t.article.content,callback:function(e){t.$set(t.article,"content",e)},expression:"article.content"}})],1),"register"===this.type?r("b-button",{staticClass:"m-1",attrs:{type:"submit",variant:"primary"}},[t._v("글작성")]):r("b-button",{staticClass:"m-1",attrs:{type:"submit",variant:"primary"}},[t._v("글수정")]),r("b-button",{staticClass:"m-1",attrs:{type:"reset",variant:"danger"}},[t._v("초기화")])],1)],1)],1)},i=[],a=r(6927),c=r(4665);const n=(0,a.b)(),o="memberStore";var l={name:"BoardInputItem",data(){return{article:{articleno:0,userid:"",subject:"",content:""},isUserid:!1}},props:{type:{type:String}},computed:{...(0,c.rn)(o,["userInfo"])},created(){"modify"===this.type&&n.get(`/board/${this.$route.params.articleno}`).then((({data:t})=>{this.article=t})),this.isUserid=!0,this.article.userid=this.userInfo.userid},methods:{onSubmit(t){t.preventDefault();let e=!0,r="";!this.article.userid&&(r="작성자 입력해주세요",e=!1,this.$refs.userid.focus()),e&&!this.article.subject&&(r="제목 입력해주세요",e=!1,this.$refs.subject.focus()),e&&!this.article.content&&(r="내용 입력해주세요",e=!1,this.$refs.content.focus()),e?"register"===this.type?this.registArticle():this.modifyArticle():alert(r)},onReset(t){t.preventDefault(),this.article.articleno=0,this.article.subject="",this.article.content="",this.$router.push({name:"boardList"})},registArticle(){n.post("/board",{userid:this.article.userid,subject:this.article.subject,content:this.article.content}).then((({data:t})=>{let e="등록 처리시 문제가 발생했습니다.";"success"===t&&(e="등록이 완료되었습니다."),alert(e),this.moveList()}))},modifyArticle(){n.put(`/board/${this.article.articleno}`,{articleno:this.article.articleno,userid:this.article.userid,subject:this.article.subject,content:this.article.content}).then((({data:t})=>{let e="수정 처리시 문제가 발생했습니다.";"success"===t&&(e="수정이 완료되었습니다."),alert(e),this.$router.push({name:"boardList"})}))},moveList(){this.$router.push({name:"boardList"})}}},u=l,b=r(1001),d=(0,b.Z)(u,s,i,!1,null,null,null),p=d.exports}}]);
//# sourceMappingURL=725.d264cd56.js.map