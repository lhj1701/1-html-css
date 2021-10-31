import { useCallback, useState } from "react";
import FullCalendar, {
  DateSelectArg,
  EventApi,
  EventClickArg
} from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import allLocales from "@fullcalendar/core/locales-all";
import interactionPlugin from "@fullcalendar/interaction";
import { createEventId } from "./event-utils";
import ko from '@fullcalendar/core';
// import esLocale from '@fullcalendar/core/locales/es';
// INITIAL_EVENTS,

function App() {
  const [currentEvents, setCurrentEvents] = useState<EventApi[]>([]);
  const handleEvents = useCallback(
    (events: EventApi[]) => setCurrentEvents(events),
    []
  );
  const handleDateSelect = useCallback((selectInfo: DateSelectArg) => {
    let title = prompt("일정을 입력하세요!")?.trim();
    let calendarApi = selectInfo.view.calendar;
    calendarApi.unselect();
    if (title) {
      calendarApi.addEvent({
        id: createEventId(),
        title,
        start: selectInfo.startStr,
        end: selectInfo.endStr,
        allDay: selectInfo.allDay
      });
    }
  }, []);
  const handleEventClick = useCallback((clickInfo: EventClickArg) => {
    if (
      window.confirm(`「${clickInfo.event.title}」일정을 삭제하시겠습니까`)
    ) {
      clickInfo.event.remove();
    }
  }, []);
  return (
    <div className="demo-app">
      <div className="demo-app-main">
        <FullCalendar
          plugins={[dayGridPlugin, interactionPlugin]}
          initialView="dayGridMonth"
          selectable={true}
          editable={true}
          // initialEvents={INITIAL_EVENTS}
          locales={allLocales}
          // locale="ja"
          locale="ko"
          eventsSet={handleEvents}
          select={handleDateSelect}
          eventClick={handleEventClick}
        />
      </div>
    </div>
  );
}

export default App;