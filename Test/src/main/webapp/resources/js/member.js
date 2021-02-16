 const el = document.getElementById('chart-area');
      const data = {
        categories: [
          'Jan',
          'Feb',
          'Mar',
          'Apr',
          'May',
          'Jun',
          'Jul',
          'Aug',
          'Sep',
          'Oct',
          'Nov',
          'Dec',
        ],
        series: [
          {
            name: 'Seoul',
            data: [20, 40, 25, 50, 15, 45, 33, 34, 20, 30, 22, 13],
          },
          {
            name: 'Sydney',
            data: [5, 30, 21, 18, 59, 50, 28, 33, 7, 20, 10, 30],
          },
          {
            name: 'Moscow',
            data: [30, 5, 18, 21, 33, 41, 29, 15, 30, 10, 33, 5],
          },
        ],
      };
      const options = {
        chart: { title: 'Average Temperature', width: 900, height: 400 },
        xAxis: { pointOnColumn: false, title: { text: 'Month' } },
        yAxis: { title: 'Temperature (Celsius)' },
        series: { spline: true },
      };

      const chart = toastui.Chart.areaChart({ el, data, options });

$(document).on('click', '#read', function() {
	selectMember();
});

function selectMember() {
	$.ajax({
		url: "selectMember.me",
		type: "post",
		dataType: "json",
		success: function(data) {
			$("#result-area").empty();

			var html = "";

			html += '<table id="testTable">';
			html += '<tr>';
			html += '<th>번호</th>';
			html += '<th>이름</th>';
			html += '<th>주소</th>';
			html += '<th>전화번호</th>';
			html += '<th>성별</th>';
			html += '<th>행삭제</th>';
			html += '<th>수정</th></tr><tr>';

			console.log(data);
			var values = data.list;
			var memberList = $.each(values, function(index, value) {
				html += '<td>' + value.no + '</td>';
				html += '<td>' + value.name + '</td>';
				html += '<td>' + value.address + '</td>';
				html += '<td>' + value.phone + '</td>';
				html += '<td>' + value.gender + '</td>';
				html += '<td><button class="delete">행삭제</button></td>';
				html += '<td><button class="update">수정하기</button></td>';
				html += '</tr>';
			});


			$("#result-area").append(html);

		}
	});
};

$(document).on('click', '.delete', function(event) {
	var target = $(this).closest('tr');
	var name = target.find('td:eq(1)').text();
	var phone = target.find('td:eq(3)').text();

	deleteMember(name, phone);
});


function deleteMember(name, phone) {
	$.ajax({
		url: "deleteMember.me",
		type: "post",
		data: { 'name': name, 'phone': phone },
		dataType: "json",
		success: function(data) {
			if (data.cnt == 1) {
				selectMember();
			} else {
				console.log(data);
				alert("실패");
			}
		}
	});
};

$(document).on('click', '#insert', function() {
	$("#result-area").empty();

	var html = "";

	html += '<table id="testTable">';
	html += '<tr>';
	html += '<th>이름</th>';
	html += '<th>주소</th>';
	html += '<th>전화번호</th>';
	html += '<th>성별</th>';
	html += '<th>추가</th>';
	html += '<tr><td><input type="text" size="6" id="name"></td>';
	html += '<td><input type="text" id="addr"></td>';
	html += '<td><input type="text" size="10" id="pho"></td>';
	html += '<td><select id="gender"><option value="M" id="M">남자</option><option value="F" id="F">여자</option></select>';
	html += '<td width="50px"><button id="insertBtn">추가</button></td></tr>';

	$("#result-area").append(html);

});

$(document).on('click', '#insertBtn', function() {
	insertMember();
});

function insertMember() {
	var name = $("#name").val();
	var address = $("#addr").val();
	var phone = $("#pho").val();
	var gender = $("#gender").val();

	if (phone.length > 11) {
		alert("전화번호는 11자 이하로 입력해주세요");
	} else if (name == "" || name == null) {
		alert("이름을 입력해주세요");
	} else {
		$.ajax({
			url: "insertMember.me",
			type: "post",
			data: { 'name': name, 'phone': phone, 'address': address, 'gender': gender },
			dataType: "json",
			success: function(data) {
				selectMember();
			}
		});
	}
};

$(document).on('click', '.update', function() {
	var target = $(this).closest('tr');
	var no = target.find('td:eq(0)').text();
	var name = target.find('td:eq(1)').text();
	var phone = target.find('td:eq(3)').text();
	var address = target.find('td:eq(2)').text();
	//var gender = target.find('td:eq(4)').text();

	$("#result-area").empty();

	var html = "";

	html += '<table id="testTable">';
	html += '<tr>';
	html += '<th>번호</th>';
	html += '<th>이름</th>';
	html += '<th>주소</th>';
	html += '<th>전화번호</th>';
	html += '<th>성별</th>';
	html += '<th>추가</th>';
	html += '<tr><td id="no">' + no + '</td>';
	html += '<td><input type="text" size="6" id="name" value="' + name + '"></td>';
	html += '<td><input type="text" id="addr" value="' + address + '"></td>';
	html += '<td><input type="text" size="10" id="pho" value="' + phone + '"></td>';
	html += '<td><select id="gender"><option value="M" id="M">남자</option><option value="F" id="F">여자</option></select>';
	html += '<td width="50px"><button id="updateBtn">수정</button></td></tr>';

	$("#result-area").append(html);
});

$(document).on('click', '#updateBtn', function() {
	updateMember();
});

function updateMember() {
	var no = $("#no").text();
	var name = $("#name").val();
	var address = $("#addr").val();
	var phone = $("#pho").val();
	var gender = $("#gender").val();

	if (phone.length > 11) {
		alert("전화번호는 11자 이하로 입력해주세요");
	} else if (name == "" || name == null) {
		alert("이름을 입력해주세요");
	} else {
		$.ajax({
			url: "updateMember.me",
			type: "post",
			data: { 'name': name, 'phone': phone, 'address': address, 'gender': gender, 'no': no },
			dataType: "json",
			success: function(data) {
				selectMember();
			}
		});
	}
};
